<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()>
Partial Class Form3ForgotPassword
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form3ForgotPassword))
        Me.btnLogin = New System.Windows.Forms.Button()
        Me.pnlReset = New System.Windows.Forms.Panel()
        Me.lblReset = New System.Windows.Forms.Label()
        Me.pnlConfirmPassword = New System.Windows.Forms.Panel()
        Me.btnShowPassword2 = New System.Windows.Forms.Button()
        Me.txtConfirmPassword = New System.Windows.Forms.TextBox()
        Me.pnlEmail = New System.Windows.Forms.Panel()
        Me.txtEmail = New System.Windows.Forms.TextBox()
        Me.pnlPassword = New System.Windows.Forms.Panel()
        Me.btnShowPassword1 = New System.Windows.Forms.Button()
        Me.txtPassword = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.ErrorProvider1 = New System.Windows.Forms.ErrorProvider(Me.components)
        Me.pnlReset.SuspendLayout()
        Me.pnlConfirmPassword.SuspendLayout()
        Me.pnlEmail.SuspendLayout()
        Me.pnlPassword.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btnLogin
        '
        Me.btnLogin.BackColor = System.Drawing.Color.Transparent
        Me.btnLogin.FlatAppearance.BorderSize = 0
        Me.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnLogin.Font = New System.Drawing.Font("Segoe UI Semibold", 9.0!, System.Drawing.FontStyle.Bold)
        Me.btnLogin.ForeColor = System.Drawing.SystemColors.ControlText
        Me.btnLogin.Location = New System.Drawing.Point(482, 425)
        Me.btnLogin.Name = "btnLogin"
        Me.btnLogin.Size = New System.Drawing.Size(82, 31)
        Me.btnLogin.TabIndex = 9
        Me.btnLogin.Text = "Log In"
        Me.btnLogin.UseVisualStyleBackColor = False
        '
        'pnlReset
        '
        Me.pnlReset.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlReset.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlReset.Controls.Add(Me.lblReset)
        Me.pnlReset.Location = New System.Drawing.Point(466, 371)
        Me.pnlReset.Name = "pnlReset"
        Me.pnlReset.Size = New System.Drawing.Size(108, 48)
        Me.pnlReset.TabIndex = 4
        '
        'lblReset
        '
        Me.lblReset.AutoSize = True
        Me.lblReset.BackColor = System.Drawing.Color.Transparent
        Me.lblReset.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblReset.Location = New System.Drawing.Point(11, 7)
        Me.lblReset.Name = "lblReset"
        Me.lblReset.Size = New System.Drawing.Size(87, 37)
        Me.lblReset.TabIndex = 8
        Me.lblReset.Text = "RESET"
        '
        'pnlConfirmPassword
        '
        Me.pnlConfirmPassword.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlConfirmPassword.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlConfirmPassword.Controls.Add(Me.btnShowPassword2)
        Me.pnlConfirmPassword.Controls.Add(Me.txtConfirmPassword)
        Me.pnlConfirmPassword.Location = New System.Drawing.Point(233, 302)
        Me.pnlConfirmPassword.Name = "pnlConfirmPassword"
        Me.pnlConfirmPassword.Size = New System.Drawing.Size(341, 58)
        Me.pnlConfirmPassword.TabIndex = 3
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
        Me.btnShowPassword2.TabIndex = 11
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
        Me.txtConfirmPassword.TabIndex = 7
        Me.txtConfirmPassword.Text = "CONFIRM PASSWORD"
        '
        'pnlEmail
        '
        Me.pnlEmail.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlEmail.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlEmail.Controls.Add(Me.txtEmail)
        Me.pnlEmail.Location = New System.Drawing.Point(233, 174)
        Me.pnlEmail.Name = "pnlEmail"
        Me.pnlEmail.Size = New System.Drawing.Size(341, 58)
        Me.pnlEmail.TabIndex = 1
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
        Me.txtEmail.TabIndex = 5
        Me.txtEmail.Text = "EMAIL"
        '
        'pnlPassword
        '
        Me.pnlPassword.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlPassword.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlPassword.Controls.Add(Me.btnShowPassword1)
        Me.pnlPassword.Controls.Add(Me.txtPassword)
        Me.pnlPassword.Location = New System.Drawing.Point(233, 238)
        Me.pnlPassword.Name = "pnlPassword"
        Me.pnlPassword.Size = New System.Drawing.Size(341, 58)
        Me.pnlPassword.TabIndex = 2
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
        Me.btnShowPassword1.TabIndex = 10
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
        Me.txtPassword.TabIndex = 6
        Me.txtPassword.Text = "PASSWORD"
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = Global.stealnt_han.My.Resources.Resources.stealnt_logo
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.ErrorImage = CType(resources.GetObject("PictureBox1.ErrorImage"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(281, 69)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(246, 71)
        Me.PictureBox1.TabIndex = 19
        Me.PictureBox1.TabStop = False
        '
        'ErrorProvider1
        '
        Me.ErrorProvider1.ContainerControl = Me
        '
        'Form3ForgotPassword
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(800, 546)
        Me.Controls.Add(Me.btnLogin)
        Me.Controls.Add(Me.pnlReset)
        Me.Controls.Add(Me.pnlConfirmPassword)
        Me.Controls.Add(Me.pnlEmail)
        Me.Controls.Add(Me.pnlPassword)
        Me.Controls.Add(Me.PictureBox1)
        Me.Name = "Form3ForgotPassword"
        Me.Text = "Forgot Password"
        Me.pnlReset.ResumeLayout(False)
        Me.pnlReset.PerformLayout()
        Me.pnlConfirmPassword.ResumeLayout(False)
        Me.pnlConfirmPassword.PerformLayout()
        Me.pnlEmail.ResumeLayout(False)
        Me.pnlEmail.PerformLayout()
        Me.pnlPassword.ResumeLayout(False)
        Me.pnlPassword.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub

    Friend WithEvents btnLogin As Button
    Friend WithEvents pnlReset As Panel
    Friend WithEvents lblReset As Label
    Friend WithEvents pnlConfirmPassword As Panel
    Friend WithEvents btnShowPassword2 As Button
    Friend WithEvents txtConfirmPassword As TextBox
    Friend WithEvents pnlEmail As Panel
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents pnlPassword As Panel
    Friend WithEvents btnShowPassword1 As Button
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents ErrorProvider1 As ErrorProvider
End Class
