Imports MySqlConnector

Public Class MonitoringForm
    Private conn As MySqlConnection

    Private Sub MonitoringForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim query As String = "SELECT camera_id, location FROM cameras"
        Dim adapter As New MySqlDataAdapter(query, conn)
        Dim table As New DataTable()
        adapter.Fill(table)

        cboCamera.DataSource = table
        cboCamera.DisplayMember = "location"
        cboCamera.ValueMember = "camera_id"
    End Sub

    Private Sub Label1_Click(sender As Object, e As EventArgs) Handles Label1.Click

    End Sub

    Private Sub cboCamera_SelectedIndexChanged(sender As Object, e As EventArgs) Handles cboCamera.SelectedIndexChanged

    End Sub

    Private Sub btnStartStream_Click(sender As Object, e As EventArgs) Handles btnStartStream.Click
        Dim ip As String = "http://192.168.1." & cboCamera.SelectedValue & ":8080/video"
        'pbLiveStream.ImageLocation = ip
    End Sub
End Class