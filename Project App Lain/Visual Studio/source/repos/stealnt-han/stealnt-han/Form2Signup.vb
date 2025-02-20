Imports MySql.Data.MySqlClient
Imports System.Data.SqlClient

Public Class Form2Signup
    Private Sub Form2Signup_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        DatabaseConnection.ConnectDatabase()  ' Panggil koneksi dari modul
    End Sub

    ' Tambahkan ErrorProvider
    Private errProvider As New ErrorProvider()

    Private Sub pnlSignup_Click(sender As Object, e As EventArgs) Handles pnlSignup.Click, lblSignup.Click
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

        ' Pastikan koneksi dibuka sebelum menjalankan query
        If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
            DatabaseConnection.ConnectDatabase()
        End If

        ' Buat user_id baru
        Dim newUserID As String = GenerateUserID()

        ' Query untuk menyisipkan data
        Dim query As String = "INSERT INTO Users (user_id, name, username, email, password) VALUES (@user_id, @name, @username, @email, @password)"

        ' Buat objek MySqlCommand
        Dim cmd As New MySqlCommand(query, DatabaseConnection.conn)

        ' Tambahkan parameter untuk query
        cmd.Parameters.AddWithValue("@user_id", newUserID)
        cmd.Parameters.AddWithValue("@name", txtName.Text)
        cmd.Parameters.AddWithValue("@username", txtUsername.Text)
        cmd.Parameters.AddWithValue("@email", txtEmail.Text)
        cmd.Parameters.AddWithValue("@password", txtPassword.Text)

        Try
            cmd.ExecuteNonQuery() ' Eksekusi query

            ' Jika registrasi berhasil, buka OTPPopup untuk verifikasi
            Dim otpPopup As New Form4OTP()
            Dim result As DialogResult = otpPopup.ShowDialog() ' Tampilkan form OTP sebagai dialog

            ' Cek hasil verifikasi OTP
            If result = DialogResult.OK Then
                MessageBox.Show("Sign up and verification successful! Please log in.")
                Form1Login.Show() ' Arahkan ke LoginForm
                Me.Hide()
            Else
                errProvider.SetError(pnlSignup, "OTP verification failed. Please try again.")
            End If
        Catch ex As Exception
            errProvider.SetError(pnlSignup, "An error occurred: " & ex.Message)
        Finally
            DatabaseConnection.DisconnectDatabase() ' Pastikan koneksi ditutup setelah operasi
        End Try
    End Sub

    Private Function GenerateUserID() As String
        Dim query As String = "SELECT user_id FROM Users ORDER BY user_id"
        Dim userIDList As New List(Of Integer)

        Try
            ' Buka koneksi dan dapatkan semua user_id
            If DatabaseConnection.conn Is Nothing OrElse DatabaseConnection.conn.State = ConnectionState.Closed Then
                DatabaseConnection.ConnectDatabase()
            End If
            Dim cmd As New MySqlCommand(query, DatabaseConnection.conn) ' Gunakan koneksi dari modul
            Dim reader As MySqlDataReader = cmd.ExecuteReader()

            ' Masukkan semua bagian numerik user_id ke dalam daftar
            While reader.Read()
                Dim userID As String = reader("user_id").ToString()
                Dim numericPart As Integer = Integer.Parse(userID.Substring(4))
                userIDList.Add(numericPart)
            End While
            reader.Close()

            ' Cari nomor yang kosong dalam urutan
            userIDList.Sort()
            For i As Integer = 1 To userIDList.Count
                If i <> userIDList(i - 1) Then
                    ' Jika ditemukan ID yang kosong, buat ID baru dengan nomor tersebut
                    Return "USER" & i.ToString("D8")
                End If
            Next

            ' Jika tidak ada ID yang kosong, buat ID baru dengan nomor berikutnya
            Dim nextID As Integer = userIDList.Count + 1
            Return "USER" & nextID.ToString("D8")
        Catch ex As Exception
            MessageBox.Show("Terjadi kesalahan saat generate user_id: " & ex.Message)
            Return Nothing
        Finally
            ' Pastikan koneksi ditutup
            'DatabaseModule.CloseConnection()
        End Try
    End Function

    Private Sub pnlUsername_Click(sender As Object, e As EventArgs) Handles pnlName.Click, txtUsername.Click
        txtUsername.Text = ""
    End Sub

    Private Sub pnlName_Click(sender As Object, e As EventArgs) Handles pnlName.Click, txtName.Click
        txtName.Text = ""
    End Sub

    Private Sub pnlEmail_Click(sender As Object, e As EventArgs) Handles pnlEmail.Click, txtEmail.Click
        txtEmail.Text = ""
    End Sub

    Private Sub pnlPassword_Click(sender As Object, e As EventArgs) Handles pnlPassword.Click, txtPassword.Click
        txtPassword.Text = ""
    End Sub
    Private Sub pnlConfirmPassword_Click(sender As Object, e As EventArgs) Handles pnlConfirmPassword.Click, txtConfirmPassword.Click
        txtConfirmPassword.Text = ""
    End Sub

    ' Fungsi untuk validasi password
    Private Function IsPasswordValid(password As String) As Boolean
        ' Minimal 8 karakter, mengandung huruf besar, angka, dan simbol
        Dim hasUpperCase As Boolean = password.Any(AddressOf Char.IsUpper)
        Dim hasNumber As Boolean = password.Any(AddressOf Char.IsDigit)
        Return password.Length >= 8 AndAlso hasUpperCase AndAlso hasNumber
    End Function

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

    Private Sub Form2Signup_FormClosed(sender As Object, e As FormClosedEventArgs) Handles MyBase.FormClosed
        DatabaseConnection.DisconnectDatabase()  ' Tutup koneksi saat form ditutup
    End Sub

    Private Sub btnLogin_Click(sender As Object, e As EventArgs) Handles btnLogin.Click
        Form1Login.Show() ' Menampilkan LoginForm
        Me.Close() ' Menutup ForgotPasswordForm
    End Sub

    Private Sub pnlSignup_Paint(sender As Object, e As PaintEventArgs) Handles pnlSignup.Paint

    End Sub

    Private Sub pnlConfirmPassword_Paint(sender As Object, e As PaintEventArgs) Handles pnlConfirmPassword.Paint

    End Sub

    Private Sub pnlEmail_Paint(sender As Object, e As PaintEventArgs) Handles pnlEmail.Paint

    End Sub

    Private Sub pnlUsername_Paint(sender As Object, e As PaintEventArgs) Handles pnlUsername.Paint

    End Sub

    Private Sub pnlPassword_Paint(sender As Object, e As PaintEventArgs) Handles pnlPassword.Paint

    End Sub

    Private Sub pnlName_Paint(sender As Object, e As PaintEventArgs) Handles pnlName.Paint

    End Sub

    Private Sub PictureBox1_Click(sender As Object, e As EventArgs) Handles PictureBox1.Click

    End Sub
End Class