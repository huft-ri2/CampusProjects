<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form1Login
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
        Me.components = New System.ComponentModel.Container()
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form1Login))
        Me.btnForgotPassword = New System.Windows.Forms.Button()
        Me.epError = New System.Windows.Forms.ErrorProvider(Me.components)
        Me.btnSignup = New System.Windows.Forms.Button()
        Me.pnlLogin = New System.Windows.Forms.Panel()
        Me.lblLogin = New System.Windows.Forms.Label()
        Me.pnlPassword = New System.Windows.Forms.Panel()
        Me.btnShowPassword = New System.Windows.Forms.Button()
        Me.txtPassword = New System.Windows.Forms.TextBox()
        Me.pnlUsername = New System.Windows.Forms.Panel()
        Me.txtUsername = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        CType(Me.epError, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.pnlLogin.SuspendLayout()
        Me.pnlPassword.SuspendLayout()
        Me.pnlUsername.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btnForgotPassword
        '
        Me.btnForgotPassword.BackColor = System.Drawing.Color.Transparent
        Me.btnForgotPassword.FlatAppearance.BorderSize = 0
        Me.btnForgotPassword.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnForgotPassword.Font = New System.Drawing.Font("Segoe UI Semibold", 9.0!, System.Drawing.FontStyle.Bold)
        Me.btnForgotPassword.ForeColor = System.Drawing.Color.Red
        Me.btnForgotPassword.Location = New System.Drawing.Point(248, 320)
        Me.btnForgotPassword.Name = "btnForgotPassword"
        Me.btnForgotPassword.Size = New System.Drawing.Size(139, 29)
        Me.btnForgotPassword.TabIndex = 5
        Me.btnForgotPassword.Text = "Forgot Password!"
        Me.btnForgotPassword.UseVisualStyleBackColor = False
        '
        'epError
        '
        Me.epError.ContainerControl = Me
        '
        'btnSignup
        '
        Me.btnSignup.BackColor = System.Drawing.Color.Transparent
        Me.btnSignup.FlatAppearance.BorderSize = 0
        Me.btnSignup.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnSignup.Font = New System.Drawing.Font("Segoe UI Semibold", 9.0!, System.Drawing.FontStyle.Bold)
        Me.btnSignup.ForeColor = System.Drawing.SystemColors.ControlText
        Me.btnSignup.Location = New System.Drawing.Point(477, 360)
        Me.btnSignup.Name = "btnSignup"
        Me.btnSignup.Size = New System.Drawing.Size(82, 31)
        Me.btnSignup.TabIndex = 7
        Me.btnSignup.Text = "Sign Up"
        Me.btnSignup.UseVisualStyleBackColor = False
        '
        'pnlLogin
        '
        Me.pnlLogin.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlLogin.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlLogin.Controls.Add(Me.lblLogin)
        Me.pnlLogin.Location = New System.Drawing.Point(464, 306)
        Me.pnlLogin.Name = "pnlLogin"
        Me.pnlLogin.Size = New System.Drawing.Size(103, 48)
        Me.pnlLogin.TabIndex = 4
        '
        'lblLogin
        '
        Me.lblLogin.AutoSize = True
        Me.lblLogin.BackColor = System.Drawing.Color.Transparent
        Me.lblLogin.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblLogin.Location = New System.Drawing.Point(9, 6)
        Me.lblLogin.Name = "lblLogin"
        Me.lblLogin.Size = New System.Drawing.Size(86, 37)
        Me.lblLogin.TabIndex = 3
        Me.lblLogin.Text = "LOGIN"
        '
        'pnlPassword
        '
        Me.pnlPassword.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlPassword.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlPassword.Controls.Add(Me.btnShowPassword)
        Me.pnlPassword.Controls.Add(Me.txtPassword)
        Me.pnlPassword.Location = New System.Drawing.Point(226, 204)
        Me.pnlPassword.Name = "pnlPassword"
        Me.pnlPassword.Size = New System.Drawing.Size(341, 58)
        Me.pnlPassword.TabIndex = 2
        '
        'btnShowPassword
        '
        Me.btnShowPassword.BackColor = System.Drawing.Color.Transparent
        Me.btnShowPassword.FlatAppearance.BorderSize = 0
        Me.btnShowPassword.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnShowPassword.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.btnShowPassword.Location = New System.Drawing.Point(284, 3)
        Me.btnShowPassword.Name = "btnShowPassword"
        Me.btnShowPassword.Size = New System.Drawing.Size(39, 50)
        Me.btnShowPassword.TabIndex = 8
        Me.btnShowPassword.Text = "👁️"
        Me.btnShowPassword.UseVisualStyleBackColor = False
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
        Me.txtPassword.TabIndex = 7
        Me.txtPassword.Text = "PASSWORD"
        '
        'pnlUsername
        '
        Me.pnlUsername.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlUsername.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlUsername.CausesValidation = False
        Me.pnlUsername.Controls.Add(Me.txtUsername)
        Me.pnlUsername.Location = New System.Drawing.Point(226, 132)
        Me.pnlUsername.Name = "pnlUsername"
        Me.pnlUsername.Size = New System.Drawing.Size(341, 58)
        Me.pnlUsername.TabIndex = 1
        '
        'txtUsername
        '
        Me.txtUsername.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtUsername.CausesValidation = False
        Me.txtUsername.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtUsername.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtUsername.ForeColor = System.Drawing.Color.Silver
        Me.txtUsername.Location = New System.Drawing.Point(22, 11)
        Me.txtUsername.Name = "txtUsername"
        Me.txtUsername.Size = New System.Drawing.Size(301, 37)
        Me.txtUsername.TabIndex = 6
        Me.txtUsername.Text = "USERNAME"
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = Global.stealnt_han.My.Resources.Resources.stealnt_logo
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.ErrorImage = CType(resources.GetObject("PictureBox1.ErrorImage"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(277, 43)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(246, 71)
        Me.PictureBox1.TabIndex = 0
        Me.PictureBox1.TabStop = False
        '
        'Form1Login
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(800, 546)
        Me.Controls.Add(Me.btnSignup)
        Me.Controls.Add(Me.btnForgotPassword)
        Me.Controls.Add(Me.pnlLogin)
        Me.Controls.Add(Me.pnlPassword)
        Me.Controls.Add(Me.pnlUsername)
        Me.Controls.Add(Me.PictureBox1)
        Me.Name = "Form1Login"
        Me.Text = "Login Form"
        CType(Me.epError, System.ComponentModel.ISupportInitialize).EndInit()
        Me.pnlLogin.ResumeLayout(False)
        Me.pnlLogin.PerformLayout()
        Me.pnlPassword.ResumeLayout(False)
        Me.pnlPassword.PerformLayout()
        Me.pnlUsername.ResumeLayout(False)
        Me.pnlUsername.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents pnlUsername As Panel
    Friend WithEvents pnlPassword As Panel
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents btnForgotPassword As Button
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents btnShowPassword As Button
    Friend WithEvents epError As ErrorProvider
    Friend WithEvents btnSignup As Button
    Friend WithEvents pnlLogin As Panel
    Friend WithEvents lblLogin As Label
End Class
