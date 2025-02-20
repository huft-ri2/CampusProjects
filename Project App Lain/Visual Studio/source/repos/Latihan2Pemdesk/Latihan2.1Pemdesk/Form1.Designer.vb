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
        iterasi = New TextBox()
        eksekusi = New Button()
        clear = New Button()
        Label2 = New Label()
        Label3 = New Label()
        Label4 = New Label()
        ganjil = New ListBox()
        genap = New ListBox()
        SuspendLayout()
        ' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.Location = New Point(11, 10)
        Label1.Name = "Label1"
        Label1.Size = New Size(99, 20)
        Label1.TabIndex = 0
        Label1.Text = "Jumlah Iterasi"
        ' 
        ' iterasi
        ' 
        iterasi.Location = New Point(129, 11)
        iterasi.Name = "iterasi"
        iterasi.Size = New Size(242, 27)
        iterasi.TabIndex = 1
        ' 
        ' eksekusi
        ' 
        eksekusi.Location = New Point(390, 10)
        eksekusi.Name = "eksekusi"
        eksekusi.Size = New Size(96, 28)
        eksekusi.TabIndex = 2
        eksekusi.Text = "Eksekusi"
        eksekusi.UseVisualStyleBackColor = True
        ' 
        ' clear
        ' 
        clear.Location = New Point(492, 8)
        clear.Name = "clear"
        clear.Size = New Size(90, 30)
        clear.TabIndex = 3
        clear.Text = "clear"
        clear.UseVisualStyleBackColor = True
        ' 
        ' Label2
        ' 
        Label2.AutoSize = True
        Label2.Location = New Point(351, 215)
        Label2.Name = "Label2"
        Label2.Size = New Size(0, 20)
        Label2.TabIndex = 4
        ' 
        ' Label3
        ' 
        Label3.AutoSize = True
        Label3.Location = New Point(64, 75)
        Label3.Name = "Label3"
        Label3.Size = New Size(93, 20)
        Label3.TabIndex = 5
        Label3.Text = "Angka Ganjil"
        ' 
        ' Label4
        ' 
        Label4.AutoSize = True
        Label4.Location = New Point(572, 75)
        Label4.Name = "Label4"
        Label4.Size = New Size(98, 20)
        Label4.TabIndex = 6
        Label4.Text = "Angka Genap"
        ' 
        ' ganjil
        ' 
        ganjil.FormattingEnabled = True
        ganjil.Location = New Point(26, 110)
        ganjil.Name = "ganjil"
        ganjil.Size = New Size(325, 304)
        ganjil.TabIndex = 7
        ' 
        ' genap
        ' 
        genap.FormattingEnabled = True
        genap.Location = New Point(439, 108)
        genap.Name = "genap"
        genap.Size = New Size(306, 304)
        genap.TabIndex = 8
        ' 
        ' Form1
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(genap)
        Controls.Add(ganjil)
        Controls.Add(Label4)
        Controls.Add(Label3)
        Controls.Add(Label2)
        Controls.Add(clear)
        Controls.Add(eksekusi)
        Controls.Add(iterasi)
        Controls.Add(Label1)
        Name = "Form1"
        Text = "Form1"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents iterasi As TextBox
    Friend WithEvents eksekusi As Button
    Friend WithEvents clear As Button
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
    Friend WithEvents Label4 As Label
    Friend WithEvents ganjil As ListBox
    Friend WithEvents genap As ListBox

End Class
