Imports MySqlConnector

Public Class NotificationsForm
    Private conn As MySqlConnection

    Private Sub NotificationsForm_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        Dim query As String = "SELECT notif_id, message, notif_time, status FROM notifications ORDER BY notif_time DESC"
        Dim adapter As New MySqlDataAdapter(query, conn)
        Dim table As New DataTable()
        adapter.Fill(table)
        dgvNotifications.DataSource = table
    End Sub

    Private Sub dgvNotifications_CellContentClick(sender As Object, e As DataGridViewCellEventArgs) Handles dgvNotifications.CellContentClick

    End Sub

    Private Sub btnMarkResolved_Click(sender As Object, e As EventArgs) Handles btnMarkResolved.Click
        Dim query As String = "UPDATE notifications SET status='resolved' WHERE notif_id=@notif_id"
        Dim cmd As New MySqlCommand(query, conn)
        cmd.Parameters.AddWithValue("@notif_id", dgvNotifications.CurrentRow.Cells("notif_id").Value)

        conn.Open()
        cmd.ExecuteNonQuery()
        conn.Close()
        MessageBox.Show("Notifikasi telah ditandai sebagai selesai.")
    End Sub
End Class