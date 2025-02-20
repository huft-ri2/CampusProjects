Public Class Form1
    Dim UT, tgs, UA, AkhirNilai As Double

    Private Sub Label2_Click(sender As Object, e As EventArgs) Handles Label2.Click

    End Sub

    Private Sub Label6_Click(sender As Object, e As EventArgs) Handles Label6.Click

    End Sub

    Private Sub hitung_Click(sender As Object, e As EventArgs) Handles hitung.Click
        tgs = CDbl(TQ.Text)
        UT = CDbl(uts.Text)
        UA = CDbl(uas.Text)
        AkhirNilai = (0.4 * tgs) + (0.3 * UT) + (0.3 * UA)
        NA.Text = AkhirNilai
    End Sub

    Private Sub npm_TextChanged(sender As Object, e As EventArgs) Handles npm.TextChanged

    End Sub
End Class
