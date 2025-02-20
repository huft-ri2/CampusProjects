Imports MySql.Data.MySqlClient

Module DatabaseConnection
    Public conn As MySqlConnection

    Public Sub ConnectDatabase()
        Dim connString As String = "server=localhost;database=stealnt3;user id=root;password=;"
        conn = New MySqlConnection(connString)
        Try
            conn.Open()
        Catch ex As Exception
            MessageBox.Show("Koneksi gagal: " & ex.Message) ' Tampilkan pesan kesalahan koneksi
        End Try
    End Sub

    Public Sub DisconnectDatabase()
        If conn IsNot Nothing AndAlso conn.State = ConnectionState.Open Then
            conn.Close()
        End If
    End Sub
End Module
