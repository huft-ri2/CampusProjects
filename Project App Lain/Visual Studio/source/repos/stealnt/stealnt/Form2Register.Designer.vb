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
        pnlName = New Panel()
        txtName = New TextBox()
        pnlEmail = New Panel()
        txtEmail = New TextBox()
        pnlRegist = New Panel()
        lblRegist = New Label()
        lblError = New Label()
        PictureBox1 = New PictureBox()
        pnlUsername = New Panel()
        txtUsername = New TextBox()
        pnlPassword = New Panel()
        btnShowPassword = New Button()
        txtPassword = New TextBox()
        btnBack = New Button()
        pnlName.SuspendLayout()
        pnlEmail.SuspendLayout()
        pnlRegist.SuspendLayout()
        CType(PictureBox1, ComponentModel.ISupportInitialize).BeginInit()
        pnlUsername.SuspendLayout()
        pnlPassword.SuspendLayout()
        SuspendLayout()
        ' 
        ' pnlName
        ' 
        pnlName.Anchor = AnchorStyles.None
        pnlName.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlName.BackgroundImageLayout = ImageLayout.Stretch
        pnlName.Controls.Add(txtName)
        pnlName.Location = New Point(211, 128)
        pnlName.Name = "pnlName"
        pnlName.Size = New Size(372, 56)
        pnlName.TabIndex = 16
        ' 
        ' txtName
        ' 
        txtName.Anchor = AnchorStyles.None
        txtName.BorderStyle = BorderStyle.None
        txtName.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtName.ForeColor = Color.Silver
        txtName.Location = New Point(23, 9)
        txtName.Name = "txtName"
        txtName.Size = New Size(315, 37)
        txtName.TabIndex = 0
        txtName.Text = "NAME"
        ' 
        ' pnlEmail
        ' 
        pnlEmail.Anchor = AnchorStyles.None
        pnlEmail.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlEmail.BackgroundImageLayout = ImageLayout.Stretch
        pnlEmail.Controls.Add(txtEmail)
        pnlEmail.Location = New Point(211, 273)
        pnlEmail.Name = "pnlEmail"
        pnlEmail.Size = New Size(372, 56)
        pnlEmail.TabIndex = 17
        ' 
        ' txtEmail
        ' 
        txtEmail.Anchor = AnchorStyles.None
        txtEmail.BorderStyle = BorderStyle.None
        txtEmail.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtEmail.ForeColor = Color.Silver
        txtEmail.Location = New Point(22, 9)
        txtEmail.Name = "txtEmail"
        txtEmail.Size = New Size(315, 37)
        txtEmail.TabIndex = 1
        txtEmail.Text = "Email"
        ' 
        ' pnlRegist
        ' 
        pnlRegist.Anchor = AnchorStyles.None
        pnlRegist.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlRegist.BackgroundImageLayout = ImageLayout.Stretch
        pnlRegist.Controls.Add(lblRegist)
        pnlRegist.Location = New Point(431, 438)
        pnlRegist.Name = "pnlRegist"
        pnlRegist.Size = New Size(152, 46)
        pnlRegist.TabIndex = 18
        ' 
        ' lblRegist
        ' 
        lblRegist.Anchor = AnchorStyles.None
        lblRegist.AutoSize = True
        lblRegist.BackColor = Color.Transparent
        lblRegist.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblRegist.ForeColor = Color.Black
        lblRegist.Location = New Point(24, 6)
        lblRegist.Name = "lblRegist"
        lblRegist.Size = New Size(101, 37)
        lblRegist.TabIndex = 1
        lblRegist.Text = "REGIST"
        ' 
        ' lblError
        ' 
        lblError.Anchor = AnchorStyles.None
        lblError.AutoSize = True
        lblError.BackColor = Color.Transparent
        lblError.FlatStyle = FlatStyle.Flat
        lblError.Font = New Font("Segoe UI", 7.8F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        lblError.Location = New Point(214, 415)
        lblError.Name = "lblError"
        lblError.Size = New Size(12, 17)
        lblError.TabIndex = 22
        lblError.Text = " "
        ' 
        ' PictureBox1
        ' 
        PictureBox1.Anchor = AnchorStyles.None
        PictureBox1.BackColor = Color.Transparent
        PictureBox1.BackgroundImage = My.Resources.Resources.stealnt_logo
        PictureBox1.BackgroundImageLayout = ImageLayout.Stretch
        PictureBox1.Image = My.Resources.Resources.stealnt_logo
        PictureBox1.Location = New Point(279, 32)
        PictureBox1.Name = "PictureBox1"
        PictureBox1.Size = New Size(234, 75)
        PictureBox1.TabIndex = 21
        PictureBox1.TabStop = False
        ' 
        ' pnlUsername
        ' 
        pnlUsername.Anchor = AnchorStyles.None
        pnlUsername.BackgroundImage = My.Resources.Resources.Text_Box_Login
        pnlUsername.BackgroundImageLayout = ImageLayout.Stretch
        pnlUsername.Controls.Add(txtUsername)
        pnlUsername.Location = New Point(211, 201)
        pnlUsername.Name = "pnlUsername"
        pnlUsername.Size = New Size(372, 56)
        pnlUsername.TabIndex = 23
        ' 
        ' txtUsername
        ' 
        txtUsername.Anchor = AnchorStyles.None
        txtUsername.BorderStyle = BorderStyle.None
        txtUsername.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtUsername.ForeColor = Color.Silver
        txtUsername.Location = New Point(22, 9)
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
        pnlPassword.Location = New Point(211, 344)
        pnlPassword.Name = "pnlPassword"
        pnlPassword.Size = New Size(372, 56)
        pnlPassword.TabIndex = 24
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
        btnShowPassword.Location = New Point(318, 3)
        btnShowPassword.Name = "btnShowPassword"
        btnShowPassword.Size = New Size(51, 50)
        btnShowPassword.TabIndex = 26
        btnShowPassword.Text = "👁️"
        btnShowPassword.UseVisualStyleBackColor = False
        ' 
        ' txtPassword
        ' 
        txtPassword.Anchor = AnchorStyles.None
        txtPassword.BorderStyle = BorderStyle.None
        txtPassword.Font = New Font("Impact", 18F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        txtPassword.ForeColor = Color.Silver
        txtPassword.Location = New Point(28, 9)
        txtPassword.Name = "txtPassword"
        txtPassword.Size = New Size(315, 37)
        txtPassword.TabIndex = 1
        txtPassword.Text = "PASSWORD"
        ' 
        ' btnBack
        ' 
        btnBack.Anchor = AnchorStyles.None
        btnBack.BackColor = Color.Transparent
        btnBack.FlatAppearance.BorderSize = 0
        btnBack.FlatStyle = FlatStyle.Flat
        btnBack.Font = New Font("Impact", 10.2F, FontStyle.Regular, GraphicsUnit.Point, CByte(0))
        btnBack.ForeColor = Color.Red
        btnBack.Location = New Point(263, 444)
        btnBack.Name = "btnBack"
        btnBack.Size = New Size(74, 32)
        btnBack.TabIndex = 19
        btnBack.Text = "Login"
        btnBack.UseVisualStyleBackColor = False
        ' 
        ' RegisterForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        BackColor = Color.White
        ClientSize = New Size(800, 527)
        Controls.Add(btnBack)
        Controls.Add(pnlUsername)
        Controls.Add(pnlPassword)
        Controls.Add(pnlName)
        Controls.Add(pnlEmail)
        Controls.Add(pnlRegist)
        Controls.Add(lblError)
        Controls.Add(PictureBox1)
        Name = "RegisterForm"
        Text = "Register Form"
        pnlName.ResumeLayout(False)
        pnlName.PerformLayout()
        pnlEmail.ResumeLayout(False)
        pnlEmail.PerformLayout()
        pnlRegist.ResumeLayout(False)
        pnlRegist.PerformLayout()
        CType(PictureBox1, ComponentModel.ISupportInitialize).EndInit()
        pnlUsername.ResumeLayout(False)
        pnlUsername.PerformLayout()
        pnlPassword.ResumeLayout(False)
        pnlPassword.PerformLayout()
        ResumeLayout(False)
        PerformLayout()
    End Sub

    Friend WithEvents pnlName As Panel
    Friend WithEvents txtName As TextBox
    Friend WithEvents pnlEmail As Panel
    Friend WithEvents txtEmail As TextBox
    Friend WithEvents pnlRegist As Panel
    Friend WithEvents lblRegist As Label
    Friend WithEvents lblError As Label
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents pnlUsername As Panel
    Friend WithEvents txtUsername As TextBox
    Friend WithEvents pnlPassword As Panel
    Friend WithEvents txtPassword As TextBox
    Friend WithEvents btnShowPassword As Button
    Friend WithEvents btnBack As Button
End Class
