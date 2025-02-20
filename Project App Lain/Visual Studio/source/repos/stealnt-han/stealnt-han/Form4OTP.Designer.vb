<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class Form4OTP
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
        Dim resources As System.ComponentModel.ComponentResourceManager = New System.ComponentModel.ComponentResourceManager(GetType(Form4OTP))
        Me.btnResend = New System.Windows.Forms.Button()
        Me.pnlVerify = New System.Windows.Forms.Panel()
        Me.lblVerify = New System.Windows.Forms.Label()
        Me.pnlEnter = New System.Windows.Forms.Panel()
        Me.txtEnter = New System.Windows.Forms.TextBox()
        Me.PictureBox1 = New System.Windows.Forms.PictureBox()
        Me.ErrorProvider1 = New System.Windows.Forms.ErrorProvider(Me.components)
        Me.lblOTP = New System.Windows.Forms.Label()
        Me.pnlVerify.SuspendLayout()
        Me.pnlEnter.SuspendLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).BeginInit()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'btnResend
        '
        Me.btnResend.BackColor = System.Drawing.Color.Transparent
        Me.btnResend.FlatAppearance.BorderSize = 0
        Me.btnResend.FlatStyle = System.Windows.Forms.FlatStyle.Flat
        Me.btnResend.Font = New System.Drawing.Font("Segoe UI Semibold", 9.0!, System.Drawing.FontStyle.Bold)
        Me.btnResend.ForeColor = System.Drawing.Color.Red
        Me.btnResend.Location = New System.Drawing.Point(159, 192)
        Me.btnResend.Name = "btnResend"
        Me.btnResend.Size = New System.Drawing.Size(240, 29)
        Me.btnResend.TabIndex = 5
        Me.btnResend.Text = "Didn't receive OTP? Resend OTP"
        Me.btnResend.UseVisualStyleBackColor = False
        '
        'pnlVerify
        '
        Me.pnlVerify.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlVerify.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlVerify.Controls.Add(Me.lblVerify)
        Me.pnlVerify.Location = New System.Drawing.Point(193, 234)
        Me.pnlVerify.Name = "pnlVerify"
        Me.pnlVerify.Size = New System.Drawing.Size(161, 48)
        Me.pnlVerify.TabIndex = 2
        '
        'lblVerify
        '
        Me.lblVerify.AutoSize = True
        Me.lblVerify.BackColor = System.Drawing.Color.Transparent
        Me.lblVerify.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblVerify.Location = New System.Drawing.Point(10, 5)
        Me.lblVerify.Name = "lblVerify"
        Me.lblVerify.Size = New System.Drawing.Size(139, 37)
        Me.lblVerify.TabIndex = 4
        Me.lblVerify.Text = "Verify OTP"
        '
        'pnlEnter
        '
        Me.pnlEnter.BackgroundImage = Global.stealnt_han.My.Resources.Resources.Text_Box_Login
        Me.pnlEnter.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.pnlEnter.Controls.Add(Me.txtEnter)
        Me.pnlEnter.Location = New System.Drawing.Point(106, 118)
        Me.pnlEnter.Name = "pnlEnter"
        Me.pnlEnter.Size = New System.Drawing.Size(341, 58)
        Me.pnlEnter.TabIndex = 1
        '
        'txtEnter
        '
        Me.txtEnter.BorderStyle = System.Windows.Forms.BorderStyle.None
        Me.txtEnter.Cursor = System.Windows.Forms.Cursors.IBeam
        Me.txtEnter.Font = New System.Drawing.Font("Impact", 18.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.txtEnter.ForeColor = System.Drawing.Color.Silver
        Me.txtEnter.Location = New System.Drawing.Point(22, 11)
        Me.txtEnter.Name = "txtEnter"
        Me.txtEnter.Size = New System.Drawing.Size(301, 37)
        Me.txtEnter.TabIndex = 3
        Me.txtEnter.Text = "ENTER OTP"
        '
        'PictureBox1
        '
        Me.PictureBox1.BackColor = System.Drawing.Color.Transparent
        Me.PictureBox1.BackgroundImage = Global.stealnt_han.My.Resources.Resources.stealnt_logo
        Me.PictureBox1.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch
        Me.PictureBox1.ErrorImage = CType(resources.GetObject("PictureBox1.ErrorImage"), System.Drawing.Image)
        Me.PictureBox1.Location = New System.Drawing.Point(156, 12)
        Me.PictureBox1.Name = "PictureBox1"
        Me.PictureBox1.Size = New System.Drawing.Size(246, 71)
        Me.PictureBox1.TabIndex = 6
        Me.PictureBox1.TabStop = False
        '
        'ErrorProvider1
        '
        Me.ErrorProvider1.ContainerControl = Me
        '
        'lblOTP
        '
        Me.lblOTP.AutoSize = True
        Me.lblOTP.Font = New System.Drawing.Font("Segoe UI Semibold", 10.2!, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, CType(0, Byte))
        Me.lblOTP.Location = New System.Drawing.Point(124, 89)
        Me.lblOTP.Name = "lblOTP"
        Me.lblOTP.Size = New System.Drawing.Size(50, 23)
        Me.lblOTP.TabIndex = 6
        Me.lblOTP.Text = "OTP: "
        '
        'Form4OTP
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.BackColor = System.Drawing.Color.White
        Me.ClientSize = New System.Drawing.Size(552, 320)
        Me.ControlBox = False
        Me.Controls.Add(Me.lblOTP)
        Me.Controls.Add(Me.btnResend)
        Me.Controls.Add(Me.pnlVerify)
        Me.Controls.Add(Me.pnlEnter)
        Me.Controls.Add(Me.PictureBox1)
        Me.Name = "Form4OTP"
        Me.Text = "OTP"
        Me.pnlVerify.ResumeLayout(False)
        Me.pnlVerify.PerformLayout()
        Me.pnlEnter.ResumeLayout(False)
        Me.pnlEnter.PerformLayout()
        CType(Me.PictureBox1, System.ComponentModel.ISupportInitialize).EndInit()
        CType(Me.ErrorProvider1, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub

    Friend WithEvents btnResend As Button
    Friend WithEvents pnlVerify As Panel
    Friend WithEvents lblVerify As Label
    Friend WithEvents pnlEnter As Panel
    Friend WithEvents txtEnter As TextBox
    Friend WithEvents PictureBox1 As PictureBox
    Friend WithEvents ErrorProvider1 As ErrorProvider
    Friend WithEvents lblOTP As Label
End Class
