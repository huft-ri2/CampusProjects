<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class DashboardForm
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
        Panel1 = New Panel()
        btnLiveStream = New Button()
        btnNotifications = New Button()
        btnLogout = New Button()
        SuspendLayout()
        ' 
        ' Panel1
        ' 
        Panel1.Location = New Point(189, 28)
        Panel1.Name = "Panel1"
        Panel1.Size = New Size(589, 410)
        Panel1.TabIndex = 0
        ' 
        ' btnLiveStream
        ' 
        btnLiveStream.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold)
        btnLiveStream.Location = New Point(28, 28)
        btnLiveStream.Name = "btnLiveStream"
        btnLiveStream.Size = New Size(121, 49)
        btnLiveStream.TabIndex = 1
        btnLiveStream.Text = "Live Stream"
        btnLiveStream.UseVisualStyleBackColor = True
        ' 
        ' btnNotifications
        ' 
        btnNotifications.Font = New Font("Segoe UI Semibold", 10.2F, FontStyle.Bold)
        btnNotifications.Location = New Point(28, 108)
        btnNotifications.Name = "btnNotifications"
        btnNotifications.Size = New Size(121, 49)
        btnNotifications.TabIndex = 2
        btnNotifications.Text = "Notifications"
        btnNotifications.UseVisualStyleBackColor = True
        ' 
        ' btnLogout
        ' 
        btnLogout.Location = New Point(28, 389)
        btnLogout.Name = "btnLogout"
        btnLogout.Size = New Size(121, 49)
        btnLogout.TabIndex = 3
        btnLogout.Text = "Logout"
        btnLogout.UseVisualStyleBackColor = True
        ' 
        ' DashboardForm
        ' 
        AutoScaleDimensions = New SizeF(8.0F, 20.0F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(btnLogout)
        Controls.Add(btnNotifications)
        Controls.Add(btnLiveStream)
        Controls.Add(Panel1)
        Name = "DashboardForm"
        Text = "Dashboard"
        ResumeLayout(False)
    End Sub

    Friend WithEvents Panel1 As Panel
    Friend WithEvents btnLiveStream As Button
    Friend WithEvents btnNotifications As Button
    Friend WithEvents btnLogout As Button
End Class
