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
        PictureBox1 = New PictureBox()
        pnlPassword = New Panel()
        btnShowPassword = New Button()
        txtPassword = New TextBox()
        pnlEmail = New Panel()
        txtEmail = New TextBox()
        pnlReset = New Panel()
        lblReset = New Label()
        btnBack = New Button()
        pnlConfirm = New Panel()
        btnShowPassword2 = New Button()
        txtConfirm = New TextBox()
        lblError = New Label()
        CType(PictureBox1, ComponentModel.ISupportInitialize).BeginInit()
        pnlPassword.SuspendLayout()
        pnlEmail.SuspendLayout()
        pnlReset.SuspendLayout()
        pnlConfirm.SuspendLayout()
        SuspendLayout()
        ' 
        ' PictureBox1
        ' 
        PictureBox1.Anchor = AnchorStyles.None
        PictureBox1.BackColor = Color.Transparent
        PictureBox1.BackgroundImage = My.Resources.Resources.stealnt_logo
        PictureBox1.BackgroundImageLayout = ImageLayout.Stretch
        PictureBox1.Image = My.Resources.Resources.stealnt_logo
        PictureBox1.Location = New Point(285, 57)
        PictureBox1.Name = "PictureBox1"
        PictureBox1.Size = New Size(234, 75)
        PictureBox1.TabIndex = 17
        PictureBox1.TabStop = False
        ' 
        ' pnlPassword
        ' 
        pnlPassword.Anchor = AnchorStyles.None
        pnlPassword.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlPassword.BackgroundImageLayout = ImageLayout.Stretch
        pnlPassword.Controls.Add(btnShowPassword)
        pnlPassword.Controls.Add(txtPassword)
        pnlPassword.Location = New Point(217, 229)
        pnlPassword.Name = "pnlPassword"
        pnlPassword.Size = New Size(372, 56)
        pnlPassword.TabIndex = 16
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
        btnShowPassword.Location = New Point(318, 2)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(51, 50)
        btnShowPassword.TabIndex = 27
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' txtPassword
        ' 
        txtPassword.Anchor = AnchorStyles.None
        txtPassword.BorderStyle = BorderStyle.None
        txtPassword.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtPassword.ForeColor = Color.Silver
        txtPassword.Location = New Point(27, 9)
        txtPassword.Name = "txtPassword"
        txtPassword.Size = New Size(315, 37)
        txtPassword.TabIndex = 1
        txtPassword.Text = "PASSWORD"
        ' 
        ' pnlEmail
        ' 
        pnlEmail.Anchor = AnchorStyles.None
        pnlEmail.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlEmail.BackgroundImageLayout = ImageLayout.Stretch
        pnlEmail.Controls.Add(txtEmail)
        pnlEmail.Location = New Point(217, 153)
        pnlEmail.Name = "pnlEmail"
        pnlEmail.Size = New Size(372, 56)
        pnlEmail.TabIndex = 15
        ' 
        ' txtEmail
        ' 
        txtEmail.Anchor = AnchorStyles.None
        txtEmail.BorderStyle = BorderStyle.None
        txtEmail.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtEmail.ForeColor = Color.Silver
        txtEmail.Location = New Point(28, 9)
        txtEmail.Name = "txtEmail"
        txtEmail.Size = New Size(315, 37)
        txtEmail.TabIndex = 0
        txtEmail.Text = "EMAIL"
        ' 
        ' pnlReset
        ' 
        pnlReset.Anchor = AnchorStyles.None
        pnlReset.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlReset.BackgroundImageLayout = ImageLayout.Stretch
        pnlReset.Controls.Add(lblReset)
        pnlReset.Location = New Point(423, 389)
        pnlReset.Name = "pnlReset"
        pnlReset.Size = New Size(152, 46)
        pnlReset.TabIndex = 20
        ' 
        ' lblReset
        ' 
        lblReset.Anchor = AnchorStyles.None
        lblReset.AutoSize = True
        lblReset.BackColor = Color.Transparent
        lblReset.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblReset.ForeColor = Color.Black
        lblReset.Location = New Point(35, 4)
        lblReset.Name = "lblReset"
        lblReset.Size = New Size(87, 37)
        lblReset.TabIndex = 1
        lblReset.Text = "RESET"
        ' 
        ' btnBack
        ' 
        btnBack.Anchor = AnchorStyles.None
        btnBack.BackColor = Color.Transparent
        btnBack.FlatAppearance.BorderSize = 0
        btnBack.FlatStyle = FlatStyle.Flat
        btnBack.Font = New Font("Impact", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnBack.ForeColor = Color.Red
        btnBack.Location = New Point(255, 395)
        btnBack.Name = "btnBack"
        btnBack.Size = New Size(74, 32)
        btnBack.TabIndex = 21
        btnBack.Text = "Login"
        btnBack.UseVisualStyleBackColor = False
        ' 
        ' pnlConfirm
        ' 
        pnlConfirm.Anchor = AnchorStyles.None
        pnlConfirm.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlConfirm.BackgroundImageLayout = ImageLayout.Stretch
        pnlConfirm.Controls.Add(btnShowPassword2)
        pnlConfirm.Controls.Add(txtConfirm)
        pnlConfirm.Location = New Point(217, 302)
        pnlConfirm.Name = "pnlConfirm"
        pnlConfirm.Size = New Size(372, 56)
        pnlConfirm.TabIndex = 28
        ' 
        ' btnShowPassword2
        ' 
        btnShowPassword2.Anchor = AnchorStyles.None
        btnShowPassword2.BackColor = Color.Transparent
        btnShowPassword2.FlatAppearance.BorderSize = 0
        btnShowPassword2.FlatAppearance.MouseDownBackColor = Color.Transparent
        btnShowPassword2.FlatAppearance.MouseOverBackColor = Color.Transparent
        btnShowPassword2.FlatStyle = FlatStyle.Flat
        btnShowPassword2.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnShowPassword2.ForeColor = Color.Black
        btnShowPassword2.Location = New Point(318, 3)
        btnShowPassword2.Name = "btnShowPassword2"
        btnShowPassword2.Size = New Size(51, 50)
        btnShowPassword2.TabIndex = 27
        btnShowPassword2.Text = "👁️"
        btnShowPassword2.UseVisualStyleBackColor = False
        ' 
        ' txtConfirm
        ' 
        txtConfirm.Anchor = AnchorStyles.None
        txtConfirm.BorderStyle = BorderStyle.None
        txtConfirm.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtConfirm.ForeColor = Color.Silver
        txtConfirm.Location = New Point(27, 9)
        txtConfirm.Name = "txtConfirm"
        txtConfirm.Size = New Size(315, 37)
        txtConfirm.TabIndex = 1
        txtConfirm.Text = "CONFIRM PASSWORD"
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.BackColor = Color.Transparent
        lblError.FlatStyle = FlatStyle.Flat
        lblError.Font = New Font("Segoe UI", 7.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblError.Location = New Point(217, 367)
        lblError.Name = "lblError"
        lblError.Size = New Size(12, 17)
        lblError.TabIndex = 23
        lblError.Text = " "
        ' 
        ' ForgotPasswordForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(lblError)
        Controls.Add(pnlConfirm)
        Controls.Add(pnlReset)
        Controls.Add(btnBack)
        Controls.Add(PictureBox1)
        Controls.Add(pnlPassword)
        Controls.Add(pnlEmail)
        Name = "ForgotPasswordForm"
        Text = "Forgot Password Form"
        CType(PictureBox1, ComponentModel.ISupportInitialize).EndInit()
        pnlPassword.ResumeLayout(False)
        pnlPassword.PerformLayout()
        pnlEmail.ResumeLayout(False)
        pnlEmail.PerformLayout()
        pnlReset.ResumeLayout(False)
        pnlReset.PerformLayout()
        pnlConfirm.ResumeLayout(False)
        pnlConfirm.PerformLayout()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents pnlPassword As Panel
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents pnlEmail As Panel
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents pnlReset As Panel
    Friend WithEvents lblReset As Label
    Friend WithEvents btnBack As Button
    Friend WithEvents btnShowPassword As Button
    Friend WithEvents pnlConfirm As Panel
    Friend WithEvents btnShowPassword2 As Button
    Friend WithEvents txtConfirm As TextBox
    Friend WithEvents lblError As Label
End Class
