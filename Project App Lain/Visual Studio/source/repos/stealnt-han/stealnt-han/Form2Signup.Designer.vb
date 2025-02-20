<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form2Signup
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
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form2Signup))
        Me.pnlPassword = New System.Windows.Forms.Panel()
        Me.btnShowPassword1 = New System.Windows.Forms.Button()
        Me.txtPassword = New System.Windows.Forms.TextBox()
        Me.pnlName = New System.Windows.Forms.Panel()
        Me.txtName = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.pnlUsername = New System.Windows.Forms.Panel()
        Me.txtUsername = New System.Windows.Forms.TextBox()
        Me.pnlEmail = New System.Windows.Forms.Panel()
        Me.txtEmail = New System.Windows.Forms.TextBox()
        Me.pnlConfirmPassword = New System.Windows.Forms.Panel()
        Me.btnShowPassword2 = New System.Windows.Forms.Button()
        Me.txtConfirmPassword = New System.Windows.Forms.TextBox()
        Me.btnLogin = New System.Windows.Forms.Button()
        Me.pnlSignup = New System.Windows.Forms.Panel()
        Me.lblSignup = New System.Windows.Forms.Label()
        Me.ErrorProvider1 = New System.Windows.Forms.ErrorProvider(Me.components)
        Me.pnlPassword.SuspendLayout()
        Me.pnlName.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.pnlUsername.SuspendLayout()
        Me.pnlEmail.SuspendLayout()
        Me.pnlConfirmPassword.SuspendLayout()
        Me.pnlSignup.SuspendLayout()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'pnlPassword
        '
        Me.pnlPassword.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlPassword.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlPassword.Controls.Add(Me.btnShowPassword1)
        Me.pnlPassword.Controls.Add(Me.txtPassword)
        Me.pnlPassword.Location = New System.Drawing.Point(227, 310)
        Me.pnlPassword.Name = "pnlPassword"
        Me.pnlPassword.Size = New System.Drawing.Size(341, 58)
        Me.pnlPassword.TabIndex = 4
        '
        'btnShowPassword1
        '
        Me.btnShowPassword1.BackColor = System.Drawing.Color.Transparent
        Me.btnShowPassword1.FlatAppearance.BorderSize = 0
        Me.btnShowPassword1.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnShowPassword1.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnShowPassword1.Location = New System.Drawing.Point(284, 3)
        Me.btnShowPassword1.Name = "btnShowPassword1"
        Me.btnShowPassword1.Size = New System.Drawing.Size(39, 50)
        Me.btnShowPassword1.TabIndex = 13
        Me.btnShowPassword1.Text = "👁️"
        Me.btnShowPassword1.UseVisualStyleBackColor = False
        '
        'txtPassword
        '
        Me.txtPassword.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtPassword.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtPassword.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtPassword.ForeColor = System.Drawing.Color.Silver
        Me.txtPassword.Location = New System.Drawing.Point(22, 10)
        Me.txtPassword.Name = "txtPassword"
        Me.txtPassword.Size = New System.Drawing.Size(256, 37)
        Me.txtPassword.TabIndex = 9
        Me.txtPassword.Text = "PASSWORD"
        '
        'pnlName
        '
        Me.pnlName.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlName.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlName.Controls.Add(Me.txtName)
        Me.pnlName.Location = New System.Drawing.Point(227, 118)
        Me.pnlName.Name = "pnlName"
        Me.pnlName.Size = New System.Drawing.Size(341, 58)
        Me.pnlName.TabIndex = 1
        '
        'txtName
        '
        Me.txtName.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtName.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtName.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtName.ForeColor = System.Drawing.Color.Silver
        Me.txtName.Location = New System.Drawing.Point(22, 11)
        Me.txtName.Name = "txtName"
        Me.txtName.Size = New System.Drawing.Size(301, 37)
        Me.txtName.TabIndex = 6
        Me.txtName.Text = "NAME"
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = Global.stealnt_han.My.Resources.Resources.stealnt_logo
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.ErrorImage = CType(resources.GetObject("PictureBox1.ErrorImage"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(278, 29)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(246, 71)
        Me.PictureBox1.TabIndex = 3
        Me.PictureBox1.TabStop = False
        '
        'pnlUsername
        '
        Me.pnlUsername.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlUsername.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlUsername.Controls.Add(Me.txtUsername)
        Me.pnlUsername.Location = New System.Drawing.Point(227, 182)
        Me.pnlUsername.Name = "pnlUsername"
        Me.pnlUsername.Size = New System.Drawing.Size(341, 58)
        Me.pnlUsername.TabIndex = 2
        '
        'txtUsername
        '
        Me.txtUsername.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtUsername.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtUsername.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtUsername.ForeColor = System.Drawing.Color.Silver
        Me.txtUsername.Location = New System.Drawing.Point(22, 11)
        Me.txtUsername.Name = "txtUsername"
        Me.txtUsername.Size = New System.Drawing.Size(301, 37)
        Me.txtUsername.TabIndex = 7
        Me.txtUsername.Text = "USERNAME"
        '
        'pnlEmail
        '
        Me.pnlEmail.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlEmail.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlEmail.Controls.Add(Me.txtEmail)
        Me.pnlEmail.Location = New System.Drawing.Point(227, 246)
        Me.pnlEmail.Name = "pnlEmail"
        Me.pnlEmail.Size = New System.Drawing.Size(341, 58)
        Me.pnlEmail.TabIndex = 3
        '
        'txtEmail
        '
        Me.txtEmail.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtEmail.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtEmail.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtEmail.ForeColor = System.Drawing.Color.Silver
        Me.txtEmail.Location = New System.Drawing.Point(22, 11)
        Me.txtEmail.Name = "txtEmail"
        Me.txtEmail.Size = New System.Drawing.Size(301, 37)
        Me.txtEmail.TabIndex = 8
        Me.txtEmail.Text = "EMAIL"
        '
        'pnlConfirmPassword
        '
        Me.pnlConfirmPassword.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlConfirmPassword.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlConfirmPassword.Controls.Add(Me.btnShowPassword2)
        Me.pnlConfirmPassword.Controls.Add(Me.txtConfirmPassword)
        Me.pnlConfirmPassword.Location = New System.Drawing.Point(227, 374)
        Me.pnlConfirmPassword.Name = "pnlConfirmPassword"
        Me.pnlConfirmPassword.Size = New System.Drawing.Size(341, 58)
        Me.pnlConfirmPassword.TabIndex = 5
        '
        'btnShowPassword2
        '
        Me.btnShowPassword2.BackColor = System.Drawing.Color.Transparent
        Me.btnShowPassword2.FlatAppearance.BorderSize = 0
        Me.btnShowPassword2.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnShowPassword2.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnShowPassword2.Location = New System.Drawing.Point(284, 3)
        Me.btnShowPassword2.Name = "btnShowPassword2"
        Me.btnShowPassword2.Size = New System.Drawing.Size(39, 50)
        Me.btnShowPassword2.TabIndex = 14
        Me.btnShowPassword2.Text = "👁️"
        Me.btnShowPassword2.UseVisualStyleBackColor = False
        '
        'txtConfirmPassword
        '
        Me.txtConfirmPassword.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtConfirmPassword.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtConfirmPassword.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtConfirmPassword.ForeColor = System.Drawing.Color.Silver
        Me.txtConfirmPassword.Location = New System.Drawing.Point(22, 10)
        Me.txtConfirmPassword.Name = "txtConfirmPassword"
        Me.txtConfirmPassword.Size = New System.Drawing.Size(256, 37)
        Me.txtConfirmPassword.TabIndex = 10
        Me.txtConfirmPassword.Text = "CONFIRM PASSWORD"
        '
        'btnLogin
        '
        Me.btnLogin.BackColor = System.Drawing.Color.Transparent
        Me.btnLogin.FlatAppearance.BorderSize = 0
        Me.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnLogin.Font = New System.Drawing.Font("Segoe UI Semibold", 9.0!, System.Drawing.FontStyle.Bold)
        Me.btnLogin.ForeColor = System.Drawing.SystemColors.ControlText
        Me.btnLogin.Location = New System.Drawing.Point(468, 497)
        Me.btnLogin.Name = "btnLogin"
        Me.btnLogin.Size = New System.Drawing.Size(82, 31)
        Me.btnLogin.TabIndex = 15
        Me.btnLogin.Text = "Log In"
        Me.btnLogin.UseVisualStyleBackColor = False
        '
        'pnlSignup
        '
        Me.pnlSignup.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlSignup.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlSignup.Controls.Add(Me.lblSignup)
        Me.pnlSignup.Location = New System.Drawing.Point(450, 443)
        Me.pnlSignup.Name = "pnlSignup"
        Me.pnlSignup.Size = New System.Drawing.Size(118, 48)
        Me.pnlSignup.TabIndex = 11
        '
        'lblSignup
        '
        Me.lblSignup.AutoSize = True
        Me.lblSignup.BackColor = System.Drawing.Color.Transparent
        Me.lblSignup.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblSignup.Location = New System.Drawing.Point(9, 6)
        Me.lblSignup.Name = "lblSignup"
        Me.lblSignup.Size = New System.Drawing.Size(106, 37)
        Me.lblSignup.TabIndex = 12
        Me.lblSignup.Text = "SIGNUP"
        '
        'ErrorProvider1
        '
        Me.ErrorProvider1.ContainerControl = Me
        '
        'Form2Signup
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(800, 546)
        Me.Controls.Add(Me.btnLogin)
        Me.Controls.Add(Me.pnlSignup)
        Me.Controls.Add(Me.pnlConfirmPassword)
        Me.Controls.Add(Me.pnlEmail)
        Me.Controls.Add(Me.pnlUsername)
        Me.Controls.Add(Me.pnlPassword)
        Me.Controls.Add(Me.pnlName)
        Me.Controls.Add(Me.PictureBox1)
        Me.Name = "Form2Signup"
        Me.Text = "Signup Form"
        Me.pnlPassword.ResumeLayout(False)
        Me.pnlPassword.PerformLayout()
        Me.pnlName.ResumeLayout(False)
        Me.pnlName.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.pnlUsername.ResumeLayout(False)
        Me.pnlUsername.PerformLayout()
        Me.pnlEmail.ResumeLayout(False)
        Me.pnlEmail.PerformLayout()
        Me.pnlConfirmPassword.ResumeLayout(False)
        Me.pnlConfirmPassword.PerformLayout()
        Me.pnlSignup.ResumeLayout(False)
        Me.pnlSignup.PerformLayout()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents pnlPassword As Panel
    Friend WithEvents btnShowPassword1 As Button
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents pnlName As Panel
    Friend WithEvents txtName As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents pnlUsername As Panel
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents pnlEmail As Panel
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents pnlConfirmPassword As Panel
    Friend WithEvents btnShowPassword2 As Button
    Friend WithEvents txtConfirmPassword As TextBox
    Friend WithEvents btnLogin As Button
    Friend WithEvents pnlSignup As Panel
    Friend WithEvents lblSignup As Label
    Friend WithEvents ErrorProvider1 As ErrorProvider
End Class
