<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class ForgotPasswordForm
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
        btnShowPassword = New Button()
        Label3 = New Label()
        txtNewPassword = New TextBox()
        txtEmail = New TextBox()
        Label2 = New Label()
        Label1 = New Label()
        btnSubmit = New Button()
        btnBack = New Button()
        lblError = New Label()
        SuspendLayout()
        ' 
        ' btnShowPassword
        ' 
        btnShowPassword.Anchor = AnchorStyles.None
        btnShowPassword.BackColor = Color.White
        btnShowPassword.FlatAppearance.BorderSize = 0
        btnShowPassword.FlatStyle = FlatStyle.Flat
        btnShowPassword.Location = New Point(526, 185)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(48, 27)
        btnShowPassword.TabIndex = 14
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' Label3
        ' 
        Label3.Anchor = AnchorStyles.None
        Label3.AutoSize = True
        Label3.Font = New Font("Clarendon BT", 13.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.Location = New Point(269, 89)
        Label3.Name = "Label3"
        Label3.Size = New Size(267, 27)
        Label3.TabIndex = 13
        Label3.Text = "FORGOT PASSWORD"
        ' 
        ' txtNewPassword
        ' 
        txtNewPassword.Anchor = AnchorStyles.None
        txtNewPassword.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtNewPassword.Location = New Point(349, 183)
        txtNewPassword.Name = "txtNewPassword"
        txtNewPassword.PasswordChar = "*"c
        txtNewPassword.Size = New Size(225, 30)
        txtNewPassword.TabIndex = 12
        ' 
        ' txtEmail
        ' 
        txtEmail.Anchor = AnchorStyles.None
        txtEmail.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtEmail.Location = New Point(349, 143)
        txtEmail.Name = "txtEmail"
        txtEmail.Size = New Size(225, 30)
        txtEmail.TabIndex = 11
        ' 
        ' Label2
        ' 
        Label2.Anchor = AnchorStyles.None
        Label2.AutoSize = True
        Label2.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label2.Location = New Point(222, 184)
        Label2.Name = "Label2"
        Label2.Size = New Size(119, 23)
        Label2.TabIndex = 10
        Label2.Text = "New Password"
        ' 
        ' Label1
        ' 
        Label1.Anchor = AnchorStyles.None
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(222, 144)
        Label1.Name = "Label1"
        Label1.Size = New Size(51, 23)
        Label1.TabIndex = 9
        Label1.Text = "Email"
        ' 
        ' btnSubmit
        ' 
        btnSubmit.Anchor = AnchorStyles.None
        btnSubmit.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnSubmit.Location = New Point(349, 250)
        btnSubmit.Name = "btnSubmit"
        btnSubmit.Size = New Size(88, 32)
        btnSubmit.TabIndex = 15
        btnSubmit.Text = "Submit"
        btnSubmit.UseVisualStyleBackColor = True
        ' 
        ' btnBack
        ' 
        btnBack.Anchor = AnchorStyles.None
        btnBack.FlatAppearance.BorderSize = 0
        btnBack.FlatStyle = FlatStyle.Flat
        btnBack.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnBack.ForeColor = Color.Red
        btnBack.Location = New Point(305, 289)
        btnBack.Name = "btnBack"
        btnBack.Size = New Size(187, 32)
        btnBack.TabIndex = 19
        btnBack.Text = "Back to Login Page"
        btnBack.UseVisualStyleBackColor = True
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.Location = New Point(349, 216)
        lblError.Name = "lblError"
        lblError.Size = New Size(0, 20)
        lblError.TabIndex = 20
        ' 
        ' ForgotPasswordForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(lblError)
        Controls.Add(btnBack)
        Controls.Add(btnSubmit)
        Controls.Add(btnShowPassword)
        Controls.Add(Label3)
        Controls.Add(txtNewPassword)
        Controls.Add(txtEmail)
        Controls.Add(Label2)
        Controls.Add(Label1)
        Name = "ForgotPasswordForm"
        Text = "Forgot Password Form"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents btnShowPassword As Button
    Friend WithEvents Label3 As Label
    Friend WithEvents txtNewPassword As TextBox
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents btnSubmit As Button
    Friend WithEvents btnBack As Button
    Friend WithEvents lblError As Label
End Class
