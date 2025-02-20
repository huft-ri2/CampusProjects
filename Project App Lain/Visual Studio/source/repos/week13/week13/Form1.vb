Imports Microsoft.Reporting.WinForms
Imports MySql.Data.MySqlClient
Imports Mysqlx.Crud
Imports System.Data.Common
Imports System.Data.SqlClient

Public Class Form1
    Private Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim orderID As Integer

        ' Validasi input
        If Not Integer.TryParse(tbOrder.Text, orderID) Then
            MessageBox.Show("Masukkan Order ID yang valid.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Warning)
            Return
        End If

        ' Buat DataTable untuk laporan
        Dim dt As New DataTable()

        Try
            ' Koneksi ke database
            Using conn As New MySqlConnection("server=localhost;database=week13pemdesk;uid=root;pwd=;")
                conn.Open()

                ' Query data
                Dim query As String = "
                    SELECT 
                        o.orderID,
                        o.TanggalOrder,
                        o.Pelanggan,
                        b.Nama_Barang,
                        d.Jumlah,
                        b.Harga,
                        d.TotalHarga,
                        p.AtasNama,
                        p.NoRekening
                    FROM tblOrder o
                    INNER JOIN tblOrderDetail d ON o.orderID = d.orderID
                    INNER JOIN tblBarang b ON d.KodeBarang = b.KodeBarang
                    CROSS JOIN tblPembayaran p
                    WHERE o.orderID = @orderID"

                ' Eksekusi query
                Using cmd As New MySqlCommand(query, conn)
                    cmd.Parameters.AddWithValue("@orderID", orderID)
                    Using adapter As New MySqlDataAdapter(cmd)
                        adapter.Fill(dt)
                    End Using
                End Using
            End Using

            ' Periksa apakah data ada
            If dt.Rows.Count = 0 Then
                MessageBox.Show("Data tidak ditemukan untuk Order ID tersebut.", "Informasi", MessageBoxButtons.OK, MessageBoxIcon.Information)
                Return
            End If

            ' Tambahkan data ke ReportViewer
            Dim rds As New ReportDataSource("DataSet1", dt) ' Pastikan "DataSet1" sesuai dengan nama di RDLC
            ReportViewer1.LocalReport.DataSources.Clear()
            ReportViewer1.LocalReport.DataSources.Add(rds)
            ReportViewer1.LocalReport.ReportPath = "C:\Users\HP\source\repos\week13\week13\Report1.rdlc" ' Pastikan path benar
            ReportViewer1.RefreshReport()


        Catch ex As Exception
            MessageBox.Show("Terjadi kesalahan: " & ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error)
        End Try
    End Sub

    Private Sub ReportViewer1_Load(sender As Object, e As EventArgs) Handles ReportViewer1.Load

    End Sub

End Class
