<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class RegisterForm
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
        btnRegister = New Button()
        txtPassword = New TextBox()
        txtUsername = New TextBox()
        Label2 = New Label()
        Label1 = New Label()
        txtEmail = New TextBox()
        Label4 = New Label()
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
        btnShowPassword.Location = New Point(522, 236)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(50, 27)
        btnShowPassword.TabIndex = 15
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' Label3
        ' 
        Label3.Anchor = AnchorStyles.None
        Label3.AutoSize = True
        Label3.Font = New Font("Clarendon BT", 24F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.Location = New Point(276, 69)
        Label3.Name = "Label3"
        Label3.Size = New Size(243, 48)
        Label3.TabIndex = 14
        Label3.Text = "REGISTER"
        Label3.TextAlign = ContentAlignment.MiddleCenter
        ' 
        ' btnRegister
        ' 
        btnRegister.Anchor = AnchorStyles.None
        btnRegister.FlatAppearance.BorderSize = 0
        btnRegister.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnRegister.Location = New Point(298, 297)
        btnRegister.Name = "btnRegister"
        btnRegister.Size = New Size(187, 47)
        btnRegister.TabIndex = 13
        btnRegister.Text = "Create New Account"
        btnRegister.UseVisualStyleBackColor = True
        ' 
        ' txtPassword
        ' 
        txtPassword.Anchor = AnchorStyles.None
        txtPassword.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtPassword.Location = New Point(347, 234)
        txtPassword.Name = "txtPassword"
        txtPassword.PasswordChar = "*"c
        txtPassword.Size = New Size(225, 30)
        txtPassword.TabIndex = 12
        ' 
        ' txtUsername
        ' 
        txtUsername.Anchor = AnchorStyles.None
        txtUsername.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtUsername.Location = New Point(347, 145)
        txtUsername.Name = "txtUsername"
        txtUsername.Size = New Size(225, 30)
        txtUsername.TabIndex = 11
        ' 
        ' Label2
        ' 
        Label2.Anchor = AnchorStyles.None
        Label2.AutoSize = True
        Label2.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label2.Location = New Point(228, 235)
        Label2.Name = "Label2"
        Label2.Size = New Size(80, 23)
        Label2.TabIndex = 10
        Label2.Text = "Password"
        ' 
        ' Label1
        ' 
        Label1.Anchor = AnchorStyles.None
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(228, 146)
        Label1.Name = "Label1"
        Label1.Size = New Size(87, 23)
        Label1.TabIndex = 9
        Label1.Text = "Username"
        ' 
        ' txtEmail
        ' 
        txtEmail.Anchor = AnchorStyles.None
        txtEmail.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtEmail.Location = New Point(347, 189)
        txtEmail.Name = "txtEmail"
        txtEmail.Size = New Size(225, 30)
        txtEmail.TabIndex = 17
        ' 
        ' Label4
        ' 
        Label4.Anchor = AnchorStyles.None
        Label4.AutoSize = True
        Label4.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label4.Location = New Point(228, 190)
        Label4.Name = "Label4"
        Label4.Size = New Size(51, 23)
        Label4.TabIndex = 16
        Label4.Text = "Email"
        ' 
        ' btnBack
        ' 
        btnBack.Anchor = AnchorStyles.None
        btnBack.FlatAppearance.BorderSize = 0
        btnBack.FlatStyle = FlatStyle.Flat
        btnBack.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnBack.ForeColor = Color.Red
        btnBack.Location = New Point(298, 355)
        btnBack.Name = "btnBack"
        btnBack.Size = New Size(187, 32)
        btnBack.TabIndex = 18
        btnBack.Text = "Back to Login Page"
        btnBack.UseVisualStyleBackColor = True
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.Location = New Point(352, 272)
        lblError.Name = "lblError"
        lblError.Size = New Size(0, 20)
        lblError.TabIndex = 19
        ' 
        ' RegisterForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(lblError)
        Controls.Add(btnBack)
        Controls.Add(txtEmail)
        Controls.Add(Label4)
        Controls.Add(btnShowPassword)
        Controls.Add(Label3)
        Controls.Add(btnRegister)
        Controls.Add(txtPassword)
        Controls.Add(txtUsername)
        Controls.Add(Label2)
        Controls.Add(Label1)
        Name = "RegisterForm"
        Text = "Register Form"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents btnShowPassword As Button
    Friend WithEvents Label3 As Label
    Friend WithEvents btnRegister As Button
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents Label2 As Label
    Friend WithEvents Label1 As Label
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents Label4 As Label
    Friend WithEvents btnBack As Button
    Friend WithEvents lblError As Label
End Class
