Public Class Form1
    Private Sub cari_Click(sender As Object, e As EventArgs) Handles cari.Click
        If CInt(umur.Text) <= 16 Then
            MsgBox("Anak-Anak")
        ElseIf CInt(umur.Text) >= 17 And CInt(umur.Text) <= 30 Then
            MsgBox("Remaja")
        ElseIf CInt(umur.Text) >= 31 And CInt(umur.Text) <= 50 Then
            MsgBox("Dewasa")
        ElseIf CInt(umur.Text) <= 51 Then
            MsgBox("Lansia")
        End If
    End Sub
End Class
