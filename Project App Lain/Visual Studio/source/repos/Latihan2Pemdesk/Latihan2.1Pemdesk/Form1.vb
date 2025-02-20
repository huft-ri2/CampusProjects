Public Class Form1
    Private Sub Label2_Click(sender As Object, e As EventArgs) Handles Label2.Click

    End Sub

    Private Sub eksekusi_Click(sender As Object, e As EventArgs) Handles eksekusi.Click
        For i As Integer = 1 To CInt(iterasi.Text)
            If i Mod 2 = 0 Then
                genap.Items.Add(i)
            Else
                ganjil.Items.Add(i)
            End If
        Next
    End Sub

    Private Sub clear_Click(sender As Object, e As EventArgs) Handles clear.Click
        iterasi.Text = " "
        ganjil.Items.Clear()
        genap.Items.Clear()
    End Sub
End Class
