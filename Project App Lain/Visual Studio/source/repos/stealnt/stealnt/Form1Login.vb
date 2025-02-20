Imports MySql.Data.MySqlClient

Public Class LoginForm
    Private Sub btnForgotPassword_Click(sender As Object, e As EventArgs) Handles btnForgotPassword.Click
        ' Buka ForgotPasswordForm
        Dim forgotForm As New ForgotPasswordForm()
        forgotForm.Show()
        Me.Hide()
    End Sub

    Private Sub pnlLogin_Click(sender As Object, e As EventArgs) Handles pnlLogin.Click, lblLogin.Click
        ' Reset pesan error di label setiap kali tombol diklik
        lblError.Text = ""
        lblError.ForeColor = Color.Red ' Atur warna teks error jadi merah

        ' Validasi jika ada field kosong
        If String.IsNullOrWhiteSpace(txtUsername.Text) OrElse
            String.IsNullOrWhiteSpace(txtPassword.Text) Then
            lblError.Text = "Semua field wajib diisi."
            Return
        End If

        ' Validasi format password
        If Not IsPasswordValid(txtPassword.Text) Then
            lblError.Text = "Password harus minimal 8 karakter, mengandung huruf besar, dan angka."
            Return
        End If

        ' Pastikan koneksi dibuka
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
            DatabaseConnection.ConnectDatabase()
        End If

        ' Periksa apakah koneksi terbuka
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State <> ConnectionState.Open Then
            MessageBox.Show("Koneksi tidak dapat dibuka. Pastikan konfigurasi database benar.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            Return
        End If

        Try
            Dim query As String = "SELECT * FROM Users WHERE username=@username AND password=@password"
            Dim cmd As New MySqlCommand(query, DatabaseConnection.conn)

            ' Tambahkan parameter untuk query
            cmd.Parameters.AddWithValue("@username", txtUsername.Text)
            cmd.Parameters.AddWithValue("@password", txtPassword.Text)

            ' Eksekusi query
            Dim reader As MySqlDataReader = cmd.ExecuteReader()
            If reader.HasRows Then
                MessageBox.Show("Login berhasil!")
                ' Arahkan ke halaman utama
                MainForm.Show()
                Me.Hide()
            Else
                lblError.Text = "Username atau password salah!"
            End If
            reader.Close()
        Catch ex As Exception
            MessageBox.Show("Error: " & ex.Message)
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

    Private Sub pnlUsername_Click(sender As Object, e As EventArgs) Handles pnlUsername.Click, txtUsername.Click
        txtUsername.Text = ""
    End Sub

    Private Sub pnlPassword_Click(sender As Object, e As EventArgs) Handles pnlPassword.Click, txtPassword.Click
        txtPassword.Text = ""
    End Sub

    Private Sub btnRegister_Click(sender As Object, e As EventArgs) Handles btnRegister.Click
        ' Buka RegisterForm
        Dim registerForm As New RegisterForm()
        registerForm.Show()
        Me.Hide()
    End Sub

    Private Sub btnShowPassword_Click(sender As Object, e As EventArgs) Handles btnShowPassword.Click
        If txtPassword.PasswordChar = "*" Then
            txtPassword.PasswordChar = ""   ' Tampilkan password
            btnShowPassword.Text = "❌"   ' Ubah teks button jadi 'Hide'
        Else
            txtPassword.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword.Text = "👁️"   ' Ubah teks button jadi 'Show'
        End If
    End Sub
End Class