<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class NotificationsForm
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
        dgvNotifications = New DataGridView()
        btnMarkResolved = New Button()
        CType(dgvNotifications, ComponentModel.ISupportInitialize).BeginInit()
        SuspendLayout()
        ' 
        ' dgvNotifications
        ' 
        dgvNotifications.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize
        dgvNotifications.Location = New Point(12, 59)
        dgvNotifications.Name = "dgvNotifications"
        dgvNotifications.RowHeadersWidth = 51
        dgvNotifications.Size = New Size(776, 379)
        dgvNotifications.TabIndex = 0
        ' 
        ' btnMarkResolved
        ' 
        btnMarkResolved.Font = New Font("Segoe UI Semibold", 9F, FontStyle.Bold, GraphicsUnit.Point, CByte(0))
        btnMarkResolved.Location = New Point(625, 14)
        btnMarkResolved.Name = "btnMarkResolved"
        btnMarkResolved.Size = New Size(150, 34)
        btnMarkResolved.TabIndex = 1
        btnMarkResolved.Text = "Selesai"
        btnMarkResolved.UseVisualStyleBackColor = True
        ' 
        ' NotificationsForm
        ' 
        AutoScaleDimensions = New SizeF(8F, 20F)
        AutoScaleMode = AutoScaleMode.Font
        ClientSize = New Size(800, 450)
        Controls.Add(btnMarkResolved)
        Controls.Add(dgvNotifications)
        Name = "NotificationsForm"
        Text = "Notifications"
        CType(dgvNotifications, ComponentModel.ISupportInitialize).EndInit()
        ResumeLayout(False)
    End Sub

    Friend WithEvents dgvNotifications As DataGridView
    Friend WithEvents btnMarkResolved As Button
End Class
