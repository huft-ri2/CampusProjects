Imports MySql.Data.MySqlClient

Public Class RegisterForm
    Private Sub RegisterForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        DatabaseConnection.ConnectDatabase()  ' Panggil koneksi dari modul
    End Sub

    Private Sub btnRegister_Click(sender As Object, e As EventArgs) Handles btnRegister.Click
        ' Reset pesan error di label setiap kali tombol diklik
        lblError.Text = ""
        lblError.ForeColor = Color.Red ' Atur warna teks error jadi merah

        ' Validasi jika ada field kosong
        If String.IsNullOrWhiteSpace(txtUsername.Text) OrElse
            String.IsNullOrWhiteSpace(txtPassword.Text) OrElse
            String.IsNullOrWhiteSpace(txtEmail.Text) Then
            lblError.Text = "Semua field wajib diisi."
            Return
        End If

        ' Validasi format password
        If Not IsPasswordValid(txtPassword.Text) Then
            lblError.Text = "Password harus minimal 8 karakter, mengandung huruf besar, dan angka."
            Return
        End If

        ' Pastikan koneksi dibuka sebelum menjalankan query
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
            DatabaseConnection.ConnectDatabase()
        End If

        Dim query As String = "INSERT INTO Users (username, email, password) VALUES (@username, @email, @password)"
        Dim cmd As New MySqlCommand(query, DatabaseConnection.conn) ' Gunakan koneksi dari modul

        cmd.Parameters.AddWithValue("@username", txtUsername.Text)
        cmd.Parameters.AddWithValue("@password", txtPassword.Text)
        cmd.Parameters.AddWithValue("@email", txtEmail.Text)

        Try
            cmd.ExecuteNonQuery() ' Eksekusi query

            ' Jika registrasi berhasil, buka OTPPopup untuk verifikasi
            Dim otpPopup As New OTPPopup()
            Dim result As DialogResult = otpPopup.ShowDialog() ' Tampilkan form OTP sebagai dialog

            ' Cek hasil verifikasi OTP
            If result = DialogResult.OK Then
                MessageBox.Show("Registrasi dan verifikasi berhasil! Silakan login.", "Success")
                LoginForm.Show() ' Arahkan ke LoginForm
                Me.Hide()
            Else
                lblError.Text = "Verifikasi OTP gagal. Silakan coba lagi."
            End If
        Catch ex As Exception
            MessageBox.Show("Registrasi gagal: " & ex.Message)
        Finally
            DatabaseConnection.DisconnectDatabase() ' Pastikan koneksi ditutup setelah operasi
        End Try
    End Sub

    ' Fungsi untuk validasi password
    Private Function IsPasswordValid(password As String) As Boolean
        ' Minimal 8 karakter, mengandung huruf besar, dan angka
        Dim hasUpperCase As Boolean = password.Any(AddressOf Char.IsUpper)
        Dim hasNumber As Boolean = password.Any(AddressOf Char.IsDigit)
        Return password.Length >= 8 AndAlso hasUpperCase AndAlso hasNumber
    End Function

    Private Sub btnShowPassword_Click(sender As Object, e As EventArgs) Handles btnShowPassword.Click
        If txtPassword.PasswordChar = "*" Then
            txtPassword.PasswordChar = ""   ' Tampilkan password
            btnShowPassword.Text = "❌"   ' Ubah teks button jadi 'Hide'
        Else
            txtPassword.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword.Text = "👁️"   ' Ubah teks button jadi 'Show'
        End If
    End Sub

    Private Sub RegisterForm_FormClosed(sender As Object, e As FormClosedEventArgs) Handles MyBase.FormClosed
        DatabaseConnection.DisconnectDatabase()  ' Tutup koneksi saat form ditutup
    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        LoginForm.Show() ' Menampilkan LoginForm
        Me.Close() ' Menutup ForgotPasswordForm
    End Sub

    Private Sub txtPassword_TextChanged(sender As Object, e As EventArgs) Handles txtPassword.TextChanged

    End Sub
End Class
