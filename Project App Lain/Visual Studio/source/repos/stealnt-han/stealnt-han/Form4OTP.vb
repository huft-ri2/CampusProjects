Public Class Form4OTP
    Private currentOTP As String

    Private Sub Form4OTP_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        GenerateAndShowOTP()
    End Sub

    ' Method untuk generate dan menampilkan OTP
    Private Sub GenerateAndShowOTP()
        Dim random As New Random()
        currentOTP = random.Next(100000, 999999).ToString() ' OTP 6 digit acak
        lblOTP.Text = "Your OTP: " & currentOTP ' Tampilkan OTP
    End Sub

    Private Sub pnlVerify_Click(sender As Object, e As EventArgs) Handles pnlVerify.Click, lblVerify.Click
        ' Validasi jika input OTP kosong
        If String.IsNullOrWhiteSpace(lblOTP.Text) Then
            MessageBox.Show("Please enter your OTP.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            Return
        End If

        ' Verifikasi OTP
        If txtEnter.Text = currentOTP Then
            MessageBox.Show("Verification successful!", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information)
            DialogResult = DialogResult.OK ' Tutup form dengan hasil sukses
        Else
            MessageBox.Show("Incorrect OTP. Please try again.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            txtEnter.Clear() ' Kosongkan input
            GenerateAndShowOTP() ' Generate OTP baru
        End If
    End Sub

    ' Generate ulang OTP saat klik "Kirim OTP Ulang"
    Private Sub btnResend_Click(sender As Object, e As EventArgs) Handles btnResend.Click
        GenerateAndShowOTP() ' Generate OTP baru
        MessageBox.Show("The new OTP has been sent!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information)
    End Sub

    Private Sub pnlEnter_Click(sender As Object, e As EventArgs) Handles pnlEnter.Click, txtEnter.Click
        txtEnter.Text = ""
    End Sub

End Class