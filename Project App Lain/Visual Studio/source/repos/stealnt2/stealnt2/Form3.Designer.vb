<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class MonitoringForm
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
        cboCamera = New ComboBox()
        PictureBox1 = New PictureBox()
        btnStartStream = New Button()
        Label1 = New Label()
        CType(PictureBox1, ComponentModel.ISupportInitialize).BeginInit()
        SuspendLayout()
        ' 
        ' cboCamera
        ' 
        cboCamera.FormattingEnabled = True
        cboCamera.Location = New Point(154, 37)
        cboCamera.Name = "cboCamera"
        cboCamera.Size = New Size(456, 28)
        cboCamera.TabIndex = 0
        ' 
        ' PictureBox1
        ' 
        PictureBox1.Location = New Point(12, 101)
        PictureBox1.Name = "PictureBox1"
        PictureBox1.Size = New Size(776, 337)
        PictureBox1.TabIndex = 1
        PictureBox1.TabStop = False
        ' 
        ' btnStartStream
        ' 
        btnStartStream.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnStartStream.Location = New Point(643, 30)
        btnStartStream.Name = "btnStartStream"
        btnStartStream.Size = New Size(132, 40)
        btnStartStream.TabIndex = 2
        btnStartStream.Text = "Start Stream"
        btnStartStream.UseVisualStyleBackColor = True
        ' 
        ' Label1
        ' 
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(24, 38)
        Label1.Name = "Label1"
        Label1.Size = New Size(109, 23)
        Label1.TabIndex = 3
        Label1.Text = "Pilih Kamera:"
        ' 
        ' MonitoringForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(Label1)
        Controls.Add(btnStartStream)
        Controls.Add(PictureBox1)
        Controls.Add(cboCamera)
        Name = "MonitoringForm"
        Text = "Monitoring"
        CType(PictureBox1, ComponentModel.ISupportInitialize).EndInit()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents cboCamera As ComboBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents btnStartStream As Button
    Friend WithEvents Label1 As Label
End Class
