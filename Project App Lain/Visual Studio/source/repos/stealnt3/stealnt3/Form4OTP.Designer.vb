<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class OTPPopup
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
        lblOTP = New Label()
        txtOTP = New TextBox()
        btnSendOTP = New Button()
        btnSubmit = New Button()
        Label1 = New Label()
        SuspendLayout()
        ' 
        ' lblOTP
        ' 
        lblOTP.Anchor = AnchorStyles.None
        lblOTP.AutoSize = True
        lblOTP.Location = New Point(52, 23)
        lblOTP.Name = "lblOTP"
        lblOTP.Size = New Size(107, 20)
        lblOTP.TabIndex = 0
        lblOTP.Text = "Masukkan OTP:"
        ' 
        ' txtOTP
        ' 
        txtOTP.Anchor = AnchorStyles.None
        txtOTP.Location = New Point(218, 20)
        txtOTP.Name = "txtOTP"
        txtOTP.Size = New Size(131, 27)
        txtOTP.TabIndex = 1
        ' 
        ' btnSendOTP
        ' 
        btnSendOTP.Anchor = AnchorStyles.None
        btnSendOTP.BackColor = Color.Transparent
        btnSendOTP.FlatAppearance.BorderSize = 0
        btnSendOTP.FlatStyle = FlatStyle.Flat
        btnSendOTP.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnSendOTP.ForeColor = Color.Red
        btnSendOTP.Location = New Point(218, 126)
        btnSendOTP.Name = "btnSendOTP"
        btnSendOTP.Size = New Size(147, 39)
        btnSendOTP.TabIndex = 2
        btnSendOTP.Text = "Kirim Ulang OTP"
        btnSendOTP.UseVisualStyleBackColor = False
        ' 
        ' btnSubmit
        ' 
        btnSubmit.Anchor = AnchorStyles.None
        btnSubmit.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnSubmit.Location = New Point(142, 71)
        btnSubmit.Name = "btnSubmit"
        btnSubmit.Size = New Size(110, 39)
        btnSubmit.TabIndex = 3
        btnSubmit.Text = "Verifikasi OTP"
        btnSubmit.UseVisualStyleBackColor = True
        ' 
        ' Label1
        ' 
        Label1.Anchor = AnchorStyles.None
        Label1.AutoSize = True
        Label1.Location = New Point(52, 135)
        Label1.Name = "Label1"
        Label1.Size = New Size(160, 20)
        Label1.TabIndex = 4
        Label1.Text = "Tidak menerima kode?"
        ' 
        ' OTPPopup
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(402, 212)
        ControlBox = False
        Controls.Add(Label1)
        Controls.Add(btnSubmit)
        Controls.Add(btnSendOTP)
        Controls.Add(txtOTP)
        Controls.Add(lblOTP)
        FormBorderStyle = FormBorderStyle.FixedDialog
        Name = "OTPPopup"
        StartPosition = FormStartPosition.CenterParent
        Text = "OTP"
        TopMost = True
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents lblOTP As Label
    Friend WithEvents txtOTP As TextBox
    Friend WithEvents btnSendOTP As Button
    Friend WithEvents btnSubmit As Button
    Friend WithEvents Label1 As Label
End Class
