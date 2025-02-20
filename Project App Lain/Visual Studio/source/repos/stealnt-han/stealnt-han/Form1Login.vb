Imports MySql.Data.MySqlClient
Imports System.Data.SqlClient

Public Class Form1Login
    Private Sub btnForgotPassword_Click(sender As Object, e As EventArgs) Handles btnForgotPassword.Click
        ' Buka ForgotPasswordForm
        Dim forgotForm As New Form3ForgotPassword()
        forgotForm.Show()
        Me.Hide()
    End Sub

    ' Tambahkan ErrorProvider
    Private errProvider As New ErrorProvider()

    Private Sub pnlLogin_Click(sender As Object, e As EventArgs) Handles pnlLogin.Click, lblLogin.Click

        ' Reset ErrorProvider
        errProvider.Clear()

        ' Validasi jika ada field kosong
        Dim isValid As Boolean = True
        If String.IsNullOrWhiteSpace(txtUsername.Text) Then
            errProvider.SetError(pnlUsername, "Username cannot be empty.")
            isValid = False
        End If

        If String.IsNullOrWhiteSpace(txtPassword.Text) Then
            errProvider.SetError(pnlPassword, "Password cannot be empty.")
            isValid = False
        End If

        ' Validate password format (one by one)
        If Not String.IsNullOrWhiteSpace(txtPassword.Text) Then
            ' Check if password length is at least 8 characters
            If txtPassword.Text.Length < 8 Then
                errProvider.SetError(pnlPassword, "Password must be at least 8 characters long.")
                isValid = False
            End If

            ' Check if password contains at least one uppercase letter
            If Not txtPassword.Text.Any(AddressOf Char.IsUpper) Then
                errProvider.SetError(pnlPassword, "Password must contain at least one uppercase letter.")
                isValid = False
            End If

            ' Check if password contains at least one number
            If Not txtPassword.Text.Any(AddressOf Char.IsDigit) Then
                errProvider.SetError(pnlPassword, "Password must contain at least one number.")
                isValid = False
            End If
        End If


        ' Hentikan proses jika validasi gagal
        If Not isValid Then Return

        ' Pastikan koneksi dibuka
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
            DatabaseConnection.ConnectDatabase()
        End If

        ' Periksa apakah koneksi terbuka
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State <> ConnectionState.Open Then
            errProvider.SetError(pnlUsername, "Unable to open the database connection. Please check the configuration.")
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
                MessageBox.Show("Login successful!")
                ' Navigate to the main form
                Form0Main.Show()
                Me.Hide()
            Else
                errProvider.SetError(pnlLogin, "Invalid username or password!")
            End If
            reader.Close()
        Catch ex As Exception
            errProvider.SetError(pnlLogin, "An error occurred: " & ex.Message)
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

    Private Sub btnSignup_Click(sender As Object, e As EventArgs) Handles btnSignup.Click
        ' Buka RegisterForm
        Dim registerForm As New Form2Signup()
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

    Private Sub Form1Login_Load(sender As Object, e As EventArgs) Handles MyBase.Load

    End Sub
End Class