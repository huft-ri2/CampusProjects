Imports MySql.Data.MySqlClient

Public Class ForgotPasswordForm
    Private Sub ForgotPasswordForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        DatabaseConnection.ConnectDatabase()  ' Panggil koneksi dari modul
    End Sub

    Private Sub pnlReset_Click(sender As Object, e As EventArgs) Handles pnlReset.Click, lblReset.Click
        ' Reset pesan error di label setiap kali tombol diklik
        lblError.Text = ""
        lblError.ForeColor = Color.Red ' Atur warna teks error jadi merah

        ' Validasi jika ada field kosong
        If String.IsNullOrWhiteSpace(txtEmail.Text) OrElse
            String.IsNullOrWhiteSpace(txtPassword.Text) OrElse
            String.IsNullOrWhiteSpace(txtConfirm.Text) Then
            lblError.Text = "Semua field wajib diisi."
            Return
        End If

        ' Validasi apakah password dan confirm password sama
        If txtPassword.Text <> txtConfirm.Text Then
            lblError.Text = "Password dan konfirmasi tidak cocok."
            Return
        End If

        ' Validasi format password
        If Not IsPasswordValid(txtPassword.Text) Then
            lblError.Text = "Password harus minimal 8 karakter, mengandung huruf besar, dan angka."
            Return
        End If

        Try
            ' Buka koneksi database jika belum terbuka
            If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
                DatabaseConnection.ConnectDatabase()
            End If

            ' Query untuk cek apakah email ada di database
            Dim query As String = "SELECT * FROM Users WHERE email=@Email"
            Using cmd As New MySqlCommand(query, DatabaseConnection.conn)
                cmd.Parameters.AddWithValue("@Email", txtEmail.Text)

                Using reader As MySqlDataReader = cmd.ExecuteReader()
                    If reader.HasRows Then
                        reader.Close() ' Tutup reader sebelum menampilkan form OTP

                        ' Tampilkan OTP Popup untuk verifikasi
                        Dim otpPopup As New OTPPopup()
                        If otpPopup.ShowDialog() = DialogResult.OK Then
                            ' Jika OTP benar, lakukan update password
                            UpdatePassword(txtEmail.Text, txtPassword.Text)

                            MessageBox.Show("Password berhasil diubah! Anda akan diarahkan ke LoginForm.",
                                        "Success", MessageBoxButtons.OK, MessageBoxIcon.Information)
                            LoginForm.Show()
                            Me.Close()
                        End If
                    Else
                        lblError.Text = "Email tidak ditemukan, Silakan coba lagi."
                    End If
                End Using
            End Using
        Catch ex As Exception
            MessageBox.Show("Error: " & ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
        Finally
            ' Tutup koneksi setelah operasi selesai
            DatabaseConnection.DisconnectDatabase()
        End Try
    End Sub

    ' Fungsi untuk mengupdate password di database
    Private Sub UpdatePassword(email As String, newPassword As String)
        Try
            ' Query untuk mengubah password
            Dim query As String = "UPDATE Users SET password=@Password WHERE email=@Email"
            Using cmd As New MySqlCommand(query, DatabaseConnection.conn)
                cmd.Parameters.AddWithValue("@Password", newPassword) ' Atur password baru
                cmd.Parameters.AddWithValue("@Email", email) ' Atur email

                cmd.ExecuteNonQuery() ' Eksekusi query
            End Using
        Catch ex As Exception
            MessageBox.Show("Error saat mengubah password: " & ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
        End Try
    End Sub

    ' Fungsi untuk validasi password
    Private Function IsPasswordValid(password As String) As Boolean
        ' Minimal 8 karakter, mengandung huruf besar, dan angka
        Dim hasUpperCase As Boolean = password.Any(AddressOf Char.IsUpper)
        Dim hasNumber As Boolean = password.Any(AddressOf Char.IsDigit)
        Return password.Length >= 8 AndAlso hasUpperCase AndAlso hasNumber
    End Function

    Private Sub pnlEmail_Click(sender As Object, e As EventArgs) Handles pnlEmail.Click, txtEmail.Click
        txtEmail.Text = ""
    End Sub

    Private Sub pnlPassword_Click(sender As Object, e As EventArgs) Handles pnlPassword.Click, txtPassword.Click
        txtPassword.Text = ""
    End Sub

    Private Sub pnlConfirm_Click(sender As Object, e As EventArgs) Handles pnlConfirm.Click, txtConfirm.Click
        txtConfirm.Text = ""
    End Sub
    Private Sub btnShowPassword_Click(sender As Object, e As EventArgs) Handles btnShowPassword.Click
        If txtPassword.PasswordChar = "*" Then
            txtPassword.PasswordChar = ""   ' Tampilkan password
            btnShowPassword.Text = "❌"      ' Ubah teks button jadi 'Hide'
        Else
            txtPassword.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword.Text = "👁️"      ' Ubah teks button jadi 'Show'
        End If
    End Sub

    Private Sub btnShowPassword2_Click(sender As Object, e As EventArgs) Handles btnShowPassword2.Click
        If txtConfirm.PasswordChar = "*" Then
            txtConfirm.PasswordChar = ""   ' Tampilkan password
            btnShowPassword.Text = "❌"      ' Ubah teks button jadi 'Hide'
        Else
            txtConfirm.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword.Text = "👁️"      ' Ubah teks button jadi 'Show'
        End If
    End Sub

    Private Sub ForgotPasswordForm_FormClosed(sender As Object, e As FormClosedEventArgs) Handles MyBase.FormClosed
        DatabaseConnection.DisconnectDatabase()  ' Tutup koneksi saat form ditutup
    End Sub

    Private Sub btnBack_Click(sender As Object, e As EventArgs) Handles btnBack.Click
        LoginForm.Show() ' Menampilkan LoginForm
        Me.Close() ' Menutup ForgotPasswordForm
    End Sub
End Class