<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()>
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()>
    Private Sub InitializeComponent()
        konek = New Button()
        ListView1 = New ListView()
        ColumnHeader1 = New ColumnHeader()
        ColumnHeader2 = New ColumnHeader()
        ColumnHeader3 = New ColumnHeader()
        ColumnHeader4 = New ColumnHeader()
        ColumnHeader5 = New ColumnHeader()
        ColumnHeader6 = New ColumnHeader()
        ColumnHeader7 = New ColumnHeader()
        Label1 = New Label()
        Label2 = New Label()
        Label3 = New Label()
        Label4 = New Label()
        Label5 = New Label()
        Label6 = New Label()
        Label7 = New Label()
        kdBrg = New TextBox()
        nmBrg = New TextBox()
        jns = New TextBox()
        stn = New TextBox()
        hb = New NumericUpDown()
        hj = New NumericUpDown()
        stok = New NumericUpDown()
        btnBr = New Button()
        btnSimpan = New Button()
        btnUbah = New Button()
        btnHps = New Button()
        CType(hb, ComponentModel.ISupportInitialize).BeginInit()
        CType(hj, ComponentModel.ISupportInitialize).BeginInit()
        CType(stok, ComponentModel.ISupportInitialize).BeginInit()
        SuspendLayout()
        ' 
        ' konek
        ' 
        konek.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        konek.Location = New Point(354, 139)
        konek.Name = "konek"
        konek.Size = New Size(89, 42)
        konek.TabIndex = 0
        konek.Text = "Koneksi"
        konek.UseVisualStyleBackColor = True
        ' 
        ' ListView1
        ' 
        ListView1.Columns.AddRange(New ColumnHeader() {ColumnHeader1, ColumnHeader2, ColumnHeader3, ColumnHeader4, ColumnHeader5, ColumnHeader6, ColumnHeader7})
        ListView1.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        ListView1.ForeColor = SystemColors.MenuText
        ListView1.FullRowSelect = True
        ListView1.Location = New Point(12, 187)
        ListView1.Name = "ListView1"
        ListView1.Size = New Size(845, 307)
        ListView1.TabIndex = 11
        ListView1.UseCompatibleStateImageBehavior = False
        ListView1.View = View.Details
        ' 
        ' ColumnHeader1
        ' 
        ColumnHeader1.Text = "Kode Barang"
        ColumnHeader1.Width = 120
        ' 
        ' ColumnHeader2
        ' 
        ColumnHeader2.Text = "Nama Barang"
        ColumnHeader2.Width = 220
        ' 
        ' ColumnHeader3
        ' 
        ColumnHeader3.Text = "Jenis"
        ColumnHeader3.Width = 100
        ' 
        ' ColumnHeader4
        ' 
        ColumnHeader4.Text = "Satuan"
        ColumnHeader4.Width = 100
        ' 
        ' ColumnHeader5
        ' 
        ColumnHeader5.Text = "Beli"
        ColumnHeader5.Width = 100
        ' 
        ' ColumnHeader6
        ' 
        ColumnHeader6.Text = "Jual"
        ColumnHeader6.Width = 100
        ' 
        ' ColumnHeader7
        ' 
        ColumnHeader7.Text = "Stok"
        ColumnHeader7.Width = 100
        ' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.BackColor = Color.Transparent
        Label1.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label1.ForeColor = SystemColors.ButtonHighlight
        Label1.Location = New Point(29, 31)
        Label1.Name = "Label1"
        Label1.Size = New Size(108, 23)
        Label1.TabIndex = 12
        Label1.Text = "Kode Barang"
        ' 
        ' Label2
        ' 
        Label2.AutoSize = True
        Label2.BackColor = Color.Transparent
        Label2.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label2.ForeColor = SystemColors.ButtonHighlight
        Label2.Location = New Point(29, 67)
        Label2.Name = "Label2"
        Label2.Size = New Size(115, 23)
        Label2.TabIndex = 13
        Label2.Text = "Nama Barang"
        ' 
        ' Label3
        ' 
        Label3.AutoSize = True
        Label3.BackColor = Color.Transparent
        Label3.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.ForeColor = SystemColors.ButtonHighlight
        Label3.Location = New Point(29, 103)
        Label3.Name = "Label3"
        Label3.Size = New Size(46, 23)
        Label3.TabIndex = 14
        Label3.Text = "Jenis"
        ' 
        ' Label4
        ' 
        Label4.AutoSize = True
        Label4.BackColor = Color.Transparent
        Label4.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label4.ForeColor = SystemColors.ButtonHighlight
        Label4.Location = New Point(29, 139)
        Label4.Name = "Label4"
        Label4.Size = New Size(63, 23)
        Label4.TabIndex = 15
        Label4.Text = "Satuan"
        ' 
        ' Label5
        ' 
        Label5.AutoSize = True
        Label5.BackColor = Color.Transparent
        Label5.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label5.ForeColor = SystemColors.ButtonHighlight
        Label5.Location = New Point(534, 67)
        Label5.Name = "Label5"
        Label5.Size = New Size(90, 23)
        Label5.TabIndex = 16
        Label5.Text = "Harga Jual"
        ' 
        ' Label6
        ' 
        Label6.AutoSize = True
        Label6.BackColor = Color.Transparent
        Label6.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label6.ForeColor = SystemColors.ButtonHighlight
        Label6.Location = New Point(534, 31)
        Label6.Name = "Label6"
        Label6.Size = New Size(88, 23)
        Label6.TabIndex = 17
        Label6.Text = "Harga Beli"
        ' 
        ' Label7
        ' 
        Label7.AutoSize = True
        Label7.BackColor = Color.Transparent
        Label7.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label7.ForeColor = SystemColors.ButtonHighlight
        Label7.Location = New Point(534, 103)
        Label7.Name = "Label7"
        Label7.Size = New Size(101, 23)
        Label7.TabIndex = 18
        Label7.Text = "Stok Barang"
        ' 
        ' kdBrg
        ' 
        kdBrg.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        kdBrg.Location = New Point(161, 28)
        kdBrg.Name = "kdBrg"
        kdBrg.Size = New Size(300, 30)
        kdBrg.TabIndex = 0
        ' 
        ' nmBrg
        ' 
        nmBrg.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        nmBrg.Location = New Point(161, 64)
        nmBrg.Name = "nmBrg"
        nmBrg.Size = New Size(347, 30)
        nmBrg.TabIndex = 1
        ' 
        ' jns
        ' 
        jns.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        jns.Location = New Point(161, 100)
        jns.Name = "jns"
        jns.Size = New Size(181, 30)
        jns.TabIndex = 2
        ' 
        ' stn
        ' 
        stn.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        stn.Location = New Point(161, 136)
        stn.Name = "stn"
        stn.Size = New Size(181, 30)
        stn.TabIndex = 3
        ' 
        ' hb
        ' 
        hb.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        hb.Location = New Point(650, 31)
        hb.Maximum = New Decimal(New Integer() {10000000, 0, 0, 0})
        hb.Name = "hb"
        hb.Size = New Size(182, 30)
        hb.TabIndex = 4
        ' 
        ' hj
        ' 
        hj.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        hj.Location = New Point(650, 67)
        hj.Maximum = New Decimal(New Integer() {10000000, 0, 0, 0})
        hj.Name = "hj"
        hj.Size = New Size(182, 30)
        hj.TabIndex = 5
        ' 
        ' stok
        ' 
        stok.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        stok.Location = New Point(650, 103)
        stok.Maximum = New Decimal(New Integer() {10000000, 0, 0, 0})
        stok.Name = "stok"
        stok.Size = New Size(182, 30)
        stok.TabIndex = 6
        ' 
        ' btnBr
        ' 
        btnBr.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnBr.Location = New Point(449, 139)
        btnBr.Name = "btnBr"
        btnBr.Size = New Size(89, 42)
        btnBr.TabIndex = 7
        btnBr.Text = "Baru"
        btnBr.UseVisualStyleBackColor = True
        ' 
        ' btnSimpan
        ' 
        btnSimpan.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnSimpan.Location = New Point(544, 139)
        btnSimpan.Name = "btnSimpan"
        btnSimpan.Size = New Size(89, 42)
        btnSimpan.TabIndex = 8
        btnSimpan.Text = "Simpan"
        btnSimpan.UseVisualStyleBackColor = True
        ' 
        ' btnUbah
        ' 
        btnUbah.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnUbah.Location = New Point(639, 139)
        btnUbah.Name = "btnUbah"
        btnUbah.Size = New Size(89, 42)
        btnUbah.TabIndex = 9
        btnUbah.Text = "Ubah"
        btnUbah.UseVisualStyleBackColor = True
        ' 
        ' btnHps
        ' 
        btnHps.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnHps.Location = New Point(734, 139)
        btnHps.Name = "btnHps"
        btnHps.Size = New Size(89, 42)
        btnHps.TabIndex = 10
        btnHps.Text = "Hapus"
        btnHps.UseVisualStyleBackColor = True
        ' 
        ' Form1
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        BackgroundImage = My.Resources.Resources.wallpaperflare_com_wallpaper__5_
        ClientSize = New Size(871, 506)
        Controls.Add(btnHps)
        Controls.Add(btnUbah)
        Controls.Add(btnSimpan)
        Controls.Add(btnBr)
        Controls.Add(stok)
        Controls.Add(hj)
        Controls.Add(hb)
        Controls.Add(stn)
        Controls.Add(jns)
        Controls.Add(nmBrg)
        Controls.Add(kdBrg)
        Controls.Add(Label7)
        Controls.Add(Label6)
        Controls.Add(Label5)
        Controls.Add(Label4)
        Controls.Add(Label3)
        Controls.Add(Label2)
        Controls.Add(Label1)
        Controls.Add(ListView1)
        Controls.Add(konek)
        Name = "Form1"
        Text = "Form1"
        CType(hb, ComponentModel.ISupportInitialize).EndInit()
        CType(hj, ComponentModel.ISupportInitialize).EndInit()
        CType(stok, ComponentModel.ISupportInitialize).EndInit()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents konek As Button
    Friend WithEvents ListView1 As ListView
    Friend WithEvents ColumnHeader1 As ColumnHeader
    Friend WithEvents ColumnHeader2 As ColumnHeader
    Friend WithEvents ColumnHeader3 As ColumnHeader
    Friend WithEvents ColumnHeader4 As ColumnHeader
    Friend WithEvents ColumnHeader5 As ColumnHeader
    Friend WithEvents ColumnHeader6 As ColumnHeader
    Friend WithEvents ColumnHeader7 As ColumnHeader
    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents Label5 As Label
    Friend WithEvents Label6 As Label
    Friend WithEvents Label7 As Label
    Friend WithEvents kdBrg As TextBox
    Friend WithEvents nmBrg As TextBox
    Friend WithEvents jns As TextBox
    Friend WithEvents stn As TextBox
    Friend WithEvents hb As NumericUpDown
    Friend WithEvents hj As NumericUpDown
    Friend WithEvents stok As NumericUpDown
    Friend WithEvents btnBr As Button
    Friend WithEvents btnSimpan As Button
    Friend WithEvents btnUbah As Button
    Friend WithEvents btnHps As Button

End Class