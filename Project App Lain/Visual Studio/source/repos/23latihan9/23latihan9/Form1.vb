Imports MySql.Data.MySqlClient
Imports Org.BouncyCastle.Bcpg

Public Class Form1
    Dim conn As New MySqlConnection
    Dim cmd As New MySqlCommand
    Dim dr As MySqlDataReader

    '    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles konek.Click
    '        Koneksi()
    '    End Sub

    '    Sub Koneksi()

    '        conn.ConnectionString = "server=localhost;user id=root;" &
    '            "password=;database=23latihan9" ' Adjust password if necessary
    '        Try
    '            conn.Open()
    '            MsgBox("Koneksi Berhasil")
    '        Catch myerror As MySqlException
    '            MsgBox("Error Koneksi: " & myerror.Message)
    '        Finally
    '            conn.Close()
    '        End Try
    '    End Sub
    '    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
    '        Koneksi()
    '        ListView1.Items.Clear()

    '        ' Replace OracleCommand with MySqlCommand
    '        cmd = New MySqlCommand("SELECT kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock FROM tblbarang", conn)

    '        ' Replace OracleDataReader with MySqlDataReader
    '        dr = cmd.ExecuteReader()

    '        If dr.HasRows Then
    '            While dr.Read()
    '                ListView1.Items.Add(dr.Item(0).ToString()) ' Convert items to strings
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(1).ToString())
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(2).ToString())
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(3).ToString())
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(4).ToString())
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(5).ToString())
    '                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(6).ToString())
    '            End While
    '            dr.Close()
    '        End If

    '        dr.Close()
    '        cmd.Dispose()
    '    End Sub

    'Private Sub Button1_Click(sender As Object, e As EventArgs) Handles konek.Click

    '    Koneksi()
    '    cmd = New MySqlCommand("select * from tblbarang", conn)
    '    dr = cmd.ExecuteReader()

    '    While dr.Read()
    '        ListView1.Items.Add(dr.Item(0))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(1))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(2))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(3))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(4))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(5))
    '        ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(6))
    '    End While
    '    dr.Close()
    'End Sub
    'Sub Koneksi()

    '    conn.ConnectionString = "server=127.0.0.1;port=3306;user id=root;" &
    '        "password=;database=23latihan9"
    '    Try
    '        conn.Open()
    '        MsgBox("Koneksi Berhasil")
    '    Catch myerror As MySqlException
    '        MsgBox("Error Koneksi: " & myerror.Message)
    '        conn.Close()
    '    End Try
    'End Sub
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles konek.Click
        Koneksi()
        LoadData()
    End Sub

    Sub Koneksi()
        conn.ConnectionString = "server=127.0.0.1;port=3306;user id=root;" &
            "password=;database=23latihan9"
        Try
            conn.Open()
            MsgBox("Koneksi Berhasil")
        Catch myerror As MySqlException
            MsgBox("Error Koneksi: " & myerror.Message)
            conn.Close()
        End Try
    End Sub

    Private Sub LoadData()
        ListView1.Items.Clear()
        cmd = New MySqlCommand("SELECT kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock FROM tblbarang", conn)

        Try
            dr = cmd.ExecuteReader()
            If dr.HasRows Then
                While dr.Read()
                    Dim item As New ListViewItem(dr.Item(0).ToString())
                    item.SubItems.Add(dr.Item(1).ToString())
                    item.SubItems.Add(dr.Item(2).ToString())
                    item.SubItems.Add(dr.Item(3).ToString())
                    item.SubItems.Add(dr.Item(4).ToString())
                    item.SubItems.Add(dr.Item(5).ToString())
                    item.SubItems.Add(dr.Item(6).ToString())
                    ListView1.Items.Add(item)
                End While
            End If
        Catch ex As Exception
            MsgBox("Error retrieving data: " & ex.Message)
        Finally
            If dr IsNot Nothing Then dr.Close()
            cmd.Dispose()
        End Try
    End Sub

    Private Sub Form1_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ' Optionally, you can call Koneksi() here if you want to establish the connection on form load
        ' Koneksi()
    End Sub

    Private Sub Label4_Click(sender As Object, e As EventArgs) Handles Label4.Click

    End Sub

    Private Sub Label5_Click(sender As Object, e As EventArgs) Handles Label5.Click

    End Sub

    Dim ctr As Control
    Private Sub btnBr_Click(sender As Object, e As EventArgs) Handles btnBr.Click
        For Each ctr In Me.Controls
            If TypeOf ctr Is TextBox Then
                ctr.Text = ""
            End If
            If TypeOf ctr Is NumericUpDown Then
                ctr.Text = "0"
            End If
        Next
    End Sub

    Private Sub btnSimpan_Click(sender As Object, e As EventArgs) Handles btnSimpan.Click
        cmd = New MySqlCommand("INSERT INTO tblbarang (kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock) VALUES ('" & kdBrg.Text & "','" & nmBrg.Text & "','" & jns.Text & "','" & stn.Text & "'," & hb.Value & "," & hj.Value & "," & stok.Value & ")", conn)
        cmd.ExecuteNonQuery()

        '''' Used to display data in ListView after inserting data
        ListView1.Items.Clear()
        cmd = New MySqlCommand("SELECT kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock FROM tblbarang", conn)
        dr = cmd.ExecuteReader()

        If dr.HasRows Then
            While dr.Read()
                ListView1.Items.Add(dr.Item(0).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(1).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(2).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(3).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(4).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(5).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(6).ToString())
            End While
            dr.Close()
        End If

        dr.Close()
        cmd.Dispose()
    End Sub

    Private Sub btnUbah_Click(sender As Object, e As EventArgs) Handles btnUbah.Click
        '''''' Used for DML syntax, this button is used to update data in MySQL
        cmd = New MySqlCommand("UPDATE tblbarang SET nama_barang='" & nmBrg.Text & "', jenis='" & jns.Text & "', satuan='" & stn.Text & "', harga_beli=" & hb.Value & ", harga_jual=" & hj.Value & ", stock=" & stok.Value & " WHERE kode_barang='" & kdBrg.Text & "'", conn)
        cmd.ExecuteNonQuery()

        '''' Used to display data in ListView after updating data
        ListView1.Items.Clear()
        cmd = New MySqlCommand("SELECT kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock FROM tblbarang", conn)
        dr = cmd.ExecuteReader()

        If dr.HasRows Then
            While dr.Read()
                ListView1.Items.Add(dr.Item(0).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(1).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(2).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(3).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(4).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(5).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(6).ToString())
            End While
            dr.Close()
        End If

        dr.Close()
        cmd.Dispose()

    End Sub

    Private Sub btnHps_Click(sender As Object, e As EventArgs) Handles btnHps.Click
        ''''' Used for DML syntax, this button is used to delete data from MySQL
        cmd = New MySqlCommand("DELETE FROM tblbarang WHERE kode_barang='" & kdBrg.Text & "'", conn)
        cmd.ExecuteNonQuery()

        '''' Used to display data in ListView after deleting data
        ListView1.Items.Clear()
        cmd = New MySqlCommand("SELECT kode_barang, nama_barang, jenis, satuan, harga_beli, harga_jual, stock FROM tblbarang", conn)
        dr = cmd.ExecuteReader()

        If dr.HasRows Then
            While dr.Read()
                ListView1.Items.Add(dr.Item(0).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(1).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(2).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(3).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(4).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(5).ToString())
                ListView1.Items(ListView1.Items.Count - 1).SubItems.Add(dr.Item(6).ToString())
            End While
            dr.Close()
        End If

        dr.Close()
        cmd.Dispose()
    End Sub

    Private Sub kdBrg_TextChanged(sender As Object, e As EventArgs) Handles kdBrg.TextChanged

    End Sub
End Class
