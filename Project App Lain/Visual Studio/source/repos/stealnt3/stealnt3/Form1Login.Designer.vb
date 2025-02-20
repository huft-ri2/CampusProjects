<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class LoginForm
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
        Label2 = New Label()
        txtUsername = New TextBox()
        txtPassword = New TextBox()
        btnLogin = New Button()
        btnForgotPassword = New Button()
        btnRegister = New Button()
        Label3 = New Label()
        btnShowPassword = New Button()
        Label4 = New Label()
        btnExit = New Button()
        lblError = New Label()
        SuspendLayout()
        ' 
        ' Label1
        ' 
        Label1.Anchor = AnchorStyles.None
        Label1.AutoSize = True
        Label1.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label1.Location = New Point(206, 131)
        Label1.Name = "Label1"
        Label1.Size = New Size(87, 23)
        Label1.TabIndex = 0
        Label1.Text = "Username"
        ' 
        ' Label2
        ' 
        Label2.Anchor = AnchorStyles.None
        Label2.AutoSize = True
        Label2.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label2.Location = New Point(206, 171)
        Label2.Name = "Label2"
        Label2.Size = New Size(80, 23)
        Label2.TabIndex = 1
        Label2.Text = "Password"
        ' 
        ' txtUsername
        ' 
        txtUsername.Anchor = AnchorStyles.None
        txtUsername.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtUsername.Location = New Point(325, 130)
        txtUsername.Name = "txtUsername"
        txtUsername.Size = New Size(225, 30)
        txtUsername.TabIndex = 2
        ' 
        ' txtPassword
        ' 
        txtPassword.Anchor = AnchorStyles.None
        txtPassword.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtPassword.Location = New Point(325, 170)
        txtPassword.Name = "txtPassword"
        txtPassword.PasswordChar = "*"c
        txtPassword.Size = New Size(225, 30)
        txtPassword.TabIndex = 3
        ' 
        ' btnLogin
        ' 
        btnLogin.Anchor = AnchorStyles.None
        btnLogin.Font = New Font("Segoe UI Semibold", 12F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnLogin.Location = New Point(322, 282)
        btnLogin.Name = "btnLogin"
        btnLogin.Size = New Size(113, 39)
        btnLogin.TabIndex = 4
        btnLogin.Text = "LOG IN"
        btnLogin.UseVisualStyleBackColor = True
        ' 
        ' btnForgotPassword
        ' 
        btnForgotPassword.Anchor = AnchorStyles.None
        btnForgotPassword.BackColor = Color.Transparent
        btnForgotPassword.BackgroundImageLayout = ImageLayout.None
        btnForgotPassword.FlatAppearance.BorderSize = 0
        btnForgotPassword.FlatStyle = FlatStyle.Flat
        btnForgotPassword.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnForgotPassword.ForeColor = Color.Red
        btnForgotPassword.ImageAlign = ContentAlignment.TopLeft
        btnForgotPassword.Location = New Point(401, 236)
        btnForgotPassword.Name = "btnForgotPassword"
        btnForgotPassword.Size = New Size(136, 32)
        btnForgotPassword.TabIndex = 5
        btnForgotPassword.Text = "Forgot Password"
        btnForgotPassword.UseMnemonic = False
        btnForgotPassword.UseVisualStyleBackColor = False
        ' 
        ' btnRegister
        ' 
        btnRegister.Anchor = AnchorStyles.None
        btnRegister.FlatAppearance.BorderSize = 0
        btnRegister.FlatStyle = FlatStyle.Flat
        btnRegister.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnRegister.Location = New Point(236, 236)
        btnRegister.Name = "btnRegister"
        btnRegister.Size = New Size(159, 32)
        btnRegister.TabIndex = 6
        btnRegister.Text = "Create New Account"
        btnRegister.UseVisualStyleBackColor = True
        ' 
        ' Label3
        ' 
        Label3.Anchor = AnchorStyles.None
        Label3.AutoSize = True
        Label3.Font = New Font("Clarendon BT", 24F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label3.Location = New Point(303, 55)
        Label3.Name = "Label3"
        Label3.Size = New Size(161, 48)
        Label3.TabIndex = 7
        Label3.Text = "LOGIN"
        ' 
        ' btnShowPassword
        ' 
        btnShowPassword.Anchor = AnchorStyles.None
        btnShowPassword.BackColor = Color.White
        btnShowPassword.FlatAppearance.BorderSize = 0
        btnShowPassword.FlatStyle = FlatStyle.Flat
        btnShowPassword.Location = New Point(499, 172)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(51, 27)
        btnShowPassword.TabIndex = 8
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' Label4
        ' 
        Label4.Anchor = AnchorStyles.None
        Label4.AutoSize = True
        Label4.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        Label4.Location = New Point(338, 337)
        Label4.Name = "Label4"
        Label4.Size = New Size(78, 23)
        Label4.TabIndex = 9
        Label4.Text = "--- or ---"
        ' 
        ' btnExit
        ' 
        btnExit.Anchor = AnchorStyles.None
        btnExit.FlatAppearance.BorderSize = 0
        btnExit.FlatStyle = FlatStyle.Flat
        btnExit.Font = New Font("Segoe UI", 10.2F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnExit.ForeColor = Color.Red
        btnExit.Location = New Point(338, 375)
        btnExit.Name = "btnExit"
        btnExit.Size = New Size(78, 32)
        btnExit.TabIndex = 10
        btnExit.Text = "EXIT"
        btnExit.UseVisualStyleBackColor = True
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.Font = New Font("Segoe UI", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblError.Location = New Point(325, 210)
        lblError.Name = "lblError"
        lblError.Size = New Size(15, 23)
        lblError.TabIndex = 11
        lblError.Text = " "
        ' 
        ' LoginForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(774, 450)
        Controls.Add(lblError)
        Controls.Add(btnExit)
        Controls.Add(Label4)
        Controls.Add(btnShowPassword)
        Controls.Add(Label3)
        Controls.Add(btnRegister)
        Controls.Add(btnForgotPassword)
        Controls.Add(btnLogin)
        Controls.Add(txtPassword)
        Controls.Add(txtUsername)
        Controls.Add(Label2)
        Controls.Add(Label1)
        Name = "LoginForm"
        Text = "Login Form"
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents Label1 As Label
    Friend WithEvents Label2 As Label
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents btnLogin As Button
    Friend WithEvents btnForgotPassword As Button
    Friend WithEvents btnRegister As Button
    Friend WithEvents Label3 As Label
    Friend WithEvents btnShowPassword As Button
    Friend WithEvents Label4 As Label
    Friend WithEvents btnExit As Button
    Friend WithEvents lblError As Label

End Class
