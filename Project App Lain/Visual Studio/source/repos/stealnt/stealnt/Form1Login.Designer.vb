<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class LoginForm
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
        pnlUsername = New Panel()
        txtUsername = New TextBox()
        pnlPassword = New Panel()
        btnShowPassword = New Button()
        txtPassword = New TextBox()
        btnRegister = New Button()
        btnForgotPassword = New Button()
        pnlLogin = New Panel()
        lblLogin = New Label()
        PictureBox1 = New PictureBox()
        lblError = New Label()
        pnlUsername.SuspendLayout()
        pnlPassword.SuspendLayout()
        pnlLogin.SuspendLayout()
        CType(PictureBox1, ComponentModel.ISupportInitialize).BeginInit()
        SuspendLayout()
        ' 
        ' pnlUsername
        ' 
        pnlUsername.Anchor = AnchorStyles.None
        pnlUsername.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlUsername.BackgroundImageLayout = ImageLayout.Stretch
        pnlUsername.Controls.Add(txtUsername)
        pnlUsername.Location = New Point(212, 150)
        pnlUsername.Name = "pnlUsername"
        pnlUsername.Size = New Size(372, 56)
        pnlUsername.TabIndex = 0
        ' 
        ' txtUsername
        ' 
        txtUsername.Anchor = AnchorStyles.None
        txtUsername.BorderStyle = BorderStyle.None
        txtUsername.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtUsername.ForeColor = Color.Silver
        txtUsername.Location = New Point(26, 9)
        txtUsername.Name = "txtUsername"
        txtUsername.Size = New Size(315, 37)
        txtUsername.TabIndex = 0
        txtUsername.Text = "USERNAME"
        ' 
        ' pnlPassword
        ' 
        pnlPassword.Anchor = AnchorStyles.None
        pnlPassword.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlPassword.BackgroundImageLayout = ImageLayout.Stretch
        pnlPassword.Controls.Add(btnShowPassword)
        pnlPassword.Controls.Add(txtPassword)
        pnlPassword.Location = New Point(212, 226)
        pnlPassword.Name = "pnlPassword"
        pnlPassword.Size = New Size(372, 56)
        pnlPassword.TabIndex = 1
        ' 
        ' btnShowPassword
        ' 
        btnShowPassword.Anchor = AnchorStyles.None
        btnShowPassword.BackColor = Color.Transparent
        btnShowPassword.FlatAppearance.BorderSize = 0
        btnShowPassword.FlatAppearance.MouseDownBackColor = Color.Transparent
        btnShowPassword.FlatAppearance.MouseOverBackColor = Color.Transparent
        btnShowPassword.FlatStyle = FlatStyle.Flat
        btnShowPassword.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnShowPassword.ForeColor = Color.Black
        btnShowPassword.Location = New Point(316, 3)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(51, 50)
        btnShowPassword.TabIndex = 14
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' txtPassword
        ' 
        txtPassword.Anchor = AnchorStyles.None
        txtPassword.BorderStyle = BorderStyle.None
        txtPassword.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtPassword.ForeColor = Color.Silver
        txtPassword.Location = New Point(26, 10)
        txtPassword.Name = "txtPassword"
        txtPassword.Size = New Size(315, 37)
        txtPassword.TabIndex = 1
        txtPassword.Text = "PASSWORD"
        ' 
        ' btnRegister
        ' 
        btnRegister.Anchor = AnchorStyles.None
        btnRegister.BackColor = Color.Transparent
        btnRegister.FlatAppearance.BorderSize = 0
        btnRegister.FlatStyle = FlatStyle.Flat
        btnRegister.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnRegister.Location = New Point(250, 377)
        btnRegister.Name = "btnRegister"
        btnRegister.Size = New Size(284, 32)
        btnRegister.TabIndex = 13
        btnRegister.Text = "--Belum punya akun? Buat akun--"
        btnRegister.UseVisualStyleBackColor = False
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
        btnForgotPassword.Location = New Point(225, 325)
        btnForgotPassword.Name = "btnForgotPassword"
        btnForgotPassword.Size = New Size(184, 32)
        btnForgotPassword.TabIndex = 12
        btnForgotPassword.Text = "LUPA PASSWORD?"
        btnForgotPassword.UseMnemonic = False
        btnForgotPassword.UseVisualStyleBackColor = False
        ' 
        ' pnlLogin
        ' 
        pnlLogin.Anchor = AnchorStyles.None
        pnlLogin.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlLogin.BackgroundImageLayout = ImageLayout.Stretch
        pnlLogin.Controls.Add(lblLogin)
        pnlLogin.Location = New Point(415, 316)
        pnlLogin.Name = "pnlLogin"
        pnlLogin.Size = New Size(152, 46)
        pnlLogin.TabIndex = 2
        ' 
        ' lblLogin
        ' 
        lblLogin.Anchor = AnchorStyles.None
        lblLogin.AutoSize = True
        lblLogin.BackColor = Color.Transparent
        lblLogin.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblLogin.ForeColor = Color.Black
        lblLogin.Location = New Point(34, 4)
        lblLogin.Name = "lblLogin"
        lblLogin.Size = New Size(86, 37)
        lblLogin.TabIndex = 1
        lblLogin.Text = "LOGIN"
        ' 
        ' PictureBox1
        ' 
        PictureBox1.Anchor = AnchorStyles.None
        PictureBox1.BackColor = Color.Transparent
        PictureBox1.BackgroundImage = My.Resources.Resources.stealnt_logo
        PictureBox1.BackgroundImageLayout = ImageLayout.Stretch
        PictureBox1.Image = My.Resources.Resources.stealnt_logo
        PictureBox1.Location = New Point(280, 54)
        PictureBox1.Name = "PictureBox1"
        PictureBox1.Size = New Size(234, 75)
        PictureBox1.TabIndex = 14
        PictureBox1.TabStop = False
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.BackColor = Color.Transparent
        lblError.FlatStyle = FlatStyle.Flat
        lblError.Font = New Font("Segoe UI", 7.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblError.Location = New Point(212, 290)
        lblError.Name = "lblError"
        lblError.Size = New Size(12, 17)
        lblError.TabIndex = 15
        lblError.Text = " "
        ' 
        ' LoginForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        BackColor = Color.White
        ClientSize = New Size(800, 505)
        Controls.Add(lblError)
        Controls.Add(PictureBox1)
        Controls.Add(pnlLogin)
        Controls.Add(btnRegister)
        Controls.Add(btnForgotPassword)
        Controls.Add(pnlPassword)
        Controls.Add(pnlUsername)
        Name = "LoginForm"
        Text = "Login Form"
        pnlUsername.ResumeLayout(False)
        pnlUsername.PerformLayout()
        pnlPassword.ResumeLayout(False)
        pnlPassword.PerformLayout()
        pnlLogin.ResumeLayout(False)
        pnlLogin.PerformLayout()
        CType(PictureBox1, ComponentModel.ISupportInitialize).EndInit()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents pnlUsername As Panel
    Friend WithEvents pnlPassword As Panel
    Friend WithEvents btnRegister As Button
    Friend WithEvents btnForgotPassword As Button
    Friend WithEvents pnlLogin As Panel
    Friend WithEvents lblLogin As Label
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents btnShowPassword As Button
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents lblError As Label
End Class
