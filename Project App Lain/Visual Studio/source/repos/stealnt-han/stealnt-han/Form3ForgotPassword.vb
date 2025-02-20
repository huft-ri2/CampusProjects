Imports MySql.Data.MySqlClient
Imports System.Data.SqlClient

Public Class Form3ForgotPassword
    Private Sub Form3ForgotPassword_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        DatabaseConnection.ConnectDatabase()  ' Panggil koneksi dari modul
    End Sub

    ' Tambahkan ErrorProvider
    Private errProvider As New ErrorProvider()

    Private Sub pnlReset_Click(sender As Object, e As EventArgs) Handles pnlReset.Click, lblReset.Click
        ' Reset ErrorProvider
        errProvider.Clear()

        ' Validasi jika ada field kosong
        Dim isValid As Boolean = True

        If String.IsNullOrWhiteSpace(txtEmail.Text) Then
            errProvider.SetError(pnlEmail, "Email is required.")
            isValid = False
        End If

        If String.IsNullOrWhiteSpace(txtPassword.Text) Then
            errProvider.SetError(pnlPassword, "Password is required.")
            isValid = False
        End If

        If String.IsNullOrWhiteSpace(txtConfirmPassword.Text) Then
            errProvider.SetError(pnlConfirmPassword, "Confirm Password is required.")
            isValid = False
        End If

        ' Validasi password format (panjang, huruf besar, angka)
        If Not String.IsNullOrWhiteSpace(txtPassword.Text) Then
            If txtPassword.Text.Length < 8 Then
                errProvider.SetError(pnlPassword, "Password must be at least 8 characters long.")
                isValid = False
            End If

            If Not txtPassword.Text.Any(AddressOf Char.IsUpper) Then
                errProvider.SetError(pnlPassword, "Password must contain at least one uppercase letter.")
                isValid = False
            End If

            If Not txtPassword.Text.Any(AddressOf Char.IsDigit) Then
                errProvider.SetError(pnlPassword, "Password must contain at least one number.")
                isValid = False
            End If
        End If

        ' Validasi konfirmasi password
        If txtPassword.Text <> txtConfirmPassword.Text Then
            errProvider.SetError(pnlConfirmPassword, "Passwords do not match.")
            isValid = False
        End If

        ' Hentikan eksekusi jika validasi gagal
        If Not isValid Then
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
                        Dim otpPopup As New Form4OTP()
                        If otpPopup.ShowDialog() = DialogResult.OK Then
                            ' Jika OTP benar, lakukan update password
                            UpdatePassword(txtEmail.Text, txtPassword.Text)

                            MessageBox.Show("Password has been successfully changed! You will be redirected to the Login Form.",
                                            "Success", MessageBoxButtons.OK, MessageBoxIcon.Information)

                            Form1Login.Show()
                            Me.Close()
                        End If
                    Else
                        errProvider.SetError(pnlEmail, "Email not found. Please try again!")
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
            MessageBox.Show("Error: " & ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
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

    Private Sub pnlConfirmPassword_Click(sender As Object, e As EventArgs) Handles pnlConfirmPassword.Click, txtConfirmPassword.Click
        txtConfirmPassword.Text = ""
    End Sub

    Private Sub btnShowPassword1_Click(sender As Object, e As EventArgs) Handles btnShowPassword1.Click
        If txtPassword.PasswordChar = "*" Then
            txtPassword.PasswordChar = ""   ' Tampilkan password
            btnShowPassword1.Text = "❌"   ' Ubah teks button jadi 'Hide'
        Else
            txtPassword.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword1.Text = "👁️"   ' Ubah teks button jadi 'Show'
        End If
    End Sub

    Private Sub btnShowPassword2_Click(sender As Object, e As EventArgs) Handles btnShowPassword2.Click
        If txtConfirmPassword.PasswordChar = "*" Then
            txtConfirmPassword.PasswordChar = ""   ' Tampilkan password
            btnShowPassword2.Text = "❌"   ' Ubah teks button jadi 'Hide'
        Else
            txtConfirmPassword.PasswordChar = "*"  ' Sembunyikan password
            btnShowPassword2.Text = "👁️"   ' Ubah teks button jadi 'Show'
        End If
    End Sub

    Private Sub ForgotPasswordForm_FormClosed(sender As Object, e As FormClosedEventArgs) Handles MyBase.FormClosed
        DatabaseConnection.DisconnectDatabase()  ' Tutup koneksi saat form ditutup
    End Sub

    Private Sub btnLogin_Click(sender As Object, e As EventArgs) Handles btnLogin.Click
        Form1Login.Show() ' Menampilkan LoginForm
        Me.Close() ' Menutup ForgotPasswordForm
    End Sub
End Class