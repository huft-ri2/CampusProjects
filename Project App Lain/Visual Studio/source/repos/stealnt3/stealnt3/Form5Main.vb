Public Class MainForm
    Private Sub btnLogout_Click(sender As Object, e As EventArgs) Handles btnLogout.Click
        Dim loginForm As New LoginForm() ' Buat instance baru LoginForm
        loginForm.Show() ' Tampilkan LoginForm
        Me.Close() ' Tutup MainForm
    End Sub
End Class