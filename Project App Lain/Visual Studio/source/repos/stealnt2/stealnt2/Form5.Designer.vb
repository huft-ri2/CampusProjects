<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class VideoForm
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
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
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Label1 = New Label()
        cboCamera = New ComboBox()
        btnDownload = New Button()
        dtpStart = New DateTimePicker()
        dtpEnd = New DateTimePicker()
        Label2 = New Label()
        Label3 = New Label()
        SuspendLayout()
        ' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(24, 28)
        Label1.Name = "Label1"
        Label1.Size = New Size(109, 23)
        Label1.TabIndex = 5
        Label1.Text = "Pilih Kamera:"
        ' 
        ' cboCamera
        ' 
        cboCamera.FormattingEnabled = True
        cboCamera.Location = New Point(154, 27)
        cboCamera.Name = "cboCamera"
        cboCamera.Size = New Size(477, 28)
        cboCamera.TabIndex = 4
        ' 
        ' btnDownload
        ' 
        btnDownload.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnDownload.Location = New Point(651, 19)
        btnDownload.Name = "btnDownload"
        btnDownload.Size = New Size(124, 42)
        btnDownload.TabIndex = 6
        btnDownload.Text = "Download"
        btnDownload.UseVisualStyleBackColor = True
        ' 
        ' dtpStart
        ' 
        dtpStart.Location = New Point(231, 75)
        dtpStart.Name = "dtpStart"
        dtpStart.Size = New Size(97, 27)
        dtpStart.TabIndex = 7
        ' 
        ' dtpEnd
        ' 
        dtpEnd.Location = New Point(508, 75)
        dtpEnd.Name = "dtpEnd"
        dtpEnd.Size = New Size(106, 27)
        dtpEnd.TabIndex = 8
        ' 
        ' Label2
        ' 
        Label2.AutoSize = True
        Label2.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label2.Location = New Point(169, 75)
        Label2.Name = "Label2"
        Label2.Size = New Size(56, 23)
        Label2.TabIndex = 9
        Label2.Text = "Mulai:"
        ' 
        ' Label3
        ' 
        Label3.AutoSize = True
        Label3.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.Location = New Point(440, 78)
        Label3.Name = "Label3"
        Label3.Size = New Size(53, 23)
        Label3.TabIndex = 10
        Label3.Text = "Akhir:"
        ' 
        ' VideoForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(Label3)
        Controls.Add(Label2)
        Controls.Add(dtpEnd)
        Controls.Add(dtpStart)
        Controls.Add(btnDownload)
        Controls.Add(Label1)
        Controls.Add(cboCamera)
        Name = "VideoForm"
        Text = "Video"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents cboCamera As ComboBox
    Friend WithEvents btnDownload As Button
    Friend WithEvents dtpStart As DateTimePicker
    Friend WithEvents dtpEnd As DateTimePicker
    Friend WithEvents Label2 As Label
    Friend WithEvents Label3 As Label
End Class
