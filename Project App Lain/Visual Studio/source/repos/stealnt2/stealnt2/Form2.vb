Public Class DashboardForm
    Private Sub Button2_Click(sender As Object, e As EventArgs) Handles btnNotifications.Click
        NotificationsForm.Show()
    End Sub

    Private Sub btnLiveStream_Click(sender As Object, e As EventArgs) Handles btnLiveStream.Click
        MonitoringForm.Show()
    End Sub

    Private Sub btnLogout_Click(sender As Object, e As EventArgs) Handles btnLogout.Click
        Me.Hide()
        LoginForm.Show()
    End Sub
End Class