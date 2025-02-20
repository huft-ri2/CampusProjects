Imports MySqlConnector

Public Class VideoForm
    Private conn As MySqlConnection
    Private Sub Label2_Click(sender As Object, e As EventArgs) Handles Label2.Click

    End Sub

    Private Sub cboCamera_SelectedIndexChanged(sender As Object, e As EventArgs) Handles cboCamera.SelectedIndexChanged

    End Sub

    Private Sub btnDownload_Click(sender As Object, e As EventArgs) Handles btnDownload.Click
        Dim query As String = "SELECT video_url FROM videos WHERE camera_id=@camera_id AND recorded_at BETWEEN @start AND @end"
        Dim cmd As New MySqlCommand(query, conn)
        cmd.Parameters.AddWithValue("@camera_id", cboCamera.SelectedValue)
        cmd.Parameters.AddWithValue("@start", dtpStart.Value)
        cmd.Parameters.AddWithValue("@end", dtpEnd.Value)

        conn.Open()
        Dim reader As MySqlDataReader = cmd.ExecuteReader()
        If reader.Read() Then
            Process.Start(reader("video_url").ToString())
        Else
            MessageBox.Show("Video tidak ditemukan.")
        End If
        conn.Close()
    End Sub
End Class