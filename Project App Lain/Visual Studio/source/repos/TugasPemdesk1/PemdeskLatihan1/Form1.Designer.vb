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
        Label1 = New Label()
        npm = New TextBox()
        nama = New TextBox()
        Label2 = New Label()
        uts = New TextBox()
        Label3 = New Label()
        TQ = New TextBox()
        Label4 = New Label()
        uas = New TextBox()
        Label5 = New Label()
        Label6 = New Label()
        hitung = New Button()
        NA = New TextBox()
        SuspendLayout()
        ' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(41, 36)
        Label1.Name = "Label1"
        Label1.Size = New Size(59, 28)
        Label1.TabIndex = 0
        Label1.Text = "NPM"
        ' 
        ' npm
        ' 
        npm.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        npm.Location = New Point(244, 33)
        npm.Name = "npm"
        npm.Size = New Size(396, 34)
        npm.TabIndex = 1
        ' 
        ' nama
        ' 
        nama.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        nama.Location = New Point(244, 73)
        nama.Name = "nama"
        nama.Size = New Size(473, 34)
        nama.TabIndex = 3
        ' 
        ' Label2
        ' 
        Label2.AutoSize = True
        Label2.Font = New Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        Label2.Location = New Point(41, 76)
        Label2.Name = "Label2"
        Label2.Size = New Size(178, 28)
        Label2.TabIndex = 2
        Label2.Text = "Nama Mahasiswa"
        ' 
        ' uts
        ' 
        uts.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        uts.Location = New Point(244, 153)
        uts.Name = "uts"
        uts.Size = New Size(125, 34)
        uts.TabIndex = 5
        uts.Text = "0"
        uts.TextAlign = HorizontalAlignment.Right
        ' 
        ' Label3
        ' 
        Label3.AutoSize = True
        Label3.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.Location = New Point(41, 156)
        Label3.Name = "Label3"
        Label3.Size = New Size(92, 28)
        Label3.TabIndex = 4
        Label3.Text = "Nilai UTS"
        ' 
        ' TQ
        ' 
        TQ.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        TQ.Location = New Point(244, 113)
        TQ.Name = "TQ"
        TQ.Size = New Size(125, 34)
        TQ.TabIndex = 7
        TQ.Text = "0"
        TQ.TextAlign = HorizontalAlignment.Right
        ' 
        ' Label4
        ' 
        Label4.AutoSize = True
        Label4.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label4.Location = New Point(41, 116)
        Label4.Name = "Label4"
        Label4.Size = New Size(191, 28)
        Label4.TabIndex = 6
        Label4.Text = "Nilai Tugas dan Quiz"
        ' 
        ' uas
        ' 
        uas.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        uas.Location = New Point(244, 194)
        uas.Name = "uas"
        uas.Size = New Size(125, 34)
        uas.TabIndex = 9
        uas.Text = "0"
        uas.TextAlign = HorizontalAlignment.Right
        ' 
        ' Label5
        ' 
        Label5.AutoSize = True
        Label5.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label5.Location = New Point(41, 197)
        Label5.Name = "Label5"
        Label5.Size = New Size(95, 28)
        Label5.TabIndex = 8
        Label5.Text = "Nilai UAS"
        ' 
        ' Label6
        ' 
        Label6.AutoSize = True
        Label6.BorderStyle = BorderStyle.FixedSingle
        Label6.Font = New Font("Segoe UI", 12F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label6.Location = New Point(478, 114)
        Label6.Name = "Label6"
        Label6.Size = New Size(188, 114)
        Label6.TabIndex = 10
        Label6.Text = "Rumus Nilai Akhir =" & vbCrLf & "(0.4*Tugas/Quiz)+" & vbCrLf & "(0.3*Nilai UTS)+" & vbCrLf & "(0.3*Nilai UAS)"
        ' 
        ' hitung
        ' 
        hitung.BackColor = SystemColors.ButtonFace
        hitung.Font = New Font("Segoe UI", 13.8F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        hitung.Location = New Point(41, 267)
        hitung.Name = "hitung"
        hitung.Size = New Size(691, 47)
        hitung.TabIndex = 11
        hitung.Text = "Hitung Dan Tampilkan Nilai Akhir"
        hitung.UseVisualStyleBackColor = False
        ' 
        ' NA
        ' 
        NA.Font = New Font("Segoe UI", 49.8000031F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        NA.Location = New Point(41, 320)
        NA.Name = "NA"
        NA.Size = New Size(691, 118)
        NA.TabIndex = 12
        NA.Text = "0"
        NA.TextAlign = HorizontalAlignment.Center
        ' 
        ' Form1
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(NA)
        Controls.Add(hitung)
        Controls.Add(Label6)
        Controls.Add(uas)
        Controls.Add(Label5)
        Controls.Add(TQ)
        Controls.Add(Label4)
        Controls.Add(uts)
        Controls.Add(Label3)
        Controls.Add(nama)
        Controls.Add(Label2)
        Controls.Add(npm)
        Controls.Add(Label1)
        Name = "Form1"
        Text = "Latihan Modul 1"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents npm As TextBox
    Friend WithEvents nama As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents uts As TextBox
    Friend WithEvents Label3 As Label
    Friend WithEvents TQ As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents uas As TextBox
    Friend WithEvents Label5 As Label
    Friend WithEvents Label6 As Label
    Friend WithEvents hitung As Button
    Friend WithEvents NA As TextBox

End Class
