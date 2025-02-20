Public Class OTPPopup
    Private currentOTP As String

    ' Saat form terbuka, generate OTP pertama kali
    Private Sub OTPPopup_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        GenerateAndShowOTP()
    End Sub

    ' Method untuk generate dan menampilkan OTP
    Private Sub GenerateAndShowOTP()
        Dim random As New Random()
        currentOTP = random.Next(100000, 999999).ToString() ' OTP 6 digit acak
        lblOTP.Text = "OTP Anda: " & currentOTP ' Tampilkan OTP
    End Sub

    Private Sub btnSubmit_Click(sender As Object, e As EventArgs) Handles btnSubmit.Click
        ' Validasi jika input OTP kosong
        If String.IsNullOrWhiteSpace(txtOTP.Text) Then
            MessageBox.Show("Masukkan OTP Anda.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            Return
        End If

        ' Verifikasi OTP
        If txtOTP.Text = currentOTP Then
            MessageBox.Show("Verifikasi berhasil!", "Success", MessageBoxButtons.OK, MessageBoxIcon.Information)
            DialogResult = DialogResult.OK ' Tutup form dengan hasil sukses
        Else
            MessageBox.Show("OTP salah. Coba lagi.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
            txtOTP.Clear() ' Kosongkan input
            GenerateAndShowOTP() ' Generate OTP baru
        End If
    End Sub

    ' Generate ulang OTP saat klik "Kirim OTP Ulang"
    Private Sub btnSendOTP_Click(sender As Object, e As EventArgs) Handles btnSendOTP.Click
        GenerateAndShowOTP() ' Generate OTP baru
        MessageBox.Show("OTP baru telah dikirim!", "Info", MessageBoxButtons.OK, MessageBoxIcon.Information)
    End Sub

    Private Sub txtOTP_TextChanged(sender As Object, e As EventArgs) Handles txtOTP.TextChanged

    End Sub
End Class
