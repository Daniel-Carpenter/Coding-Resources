Attribute VB_Name = "Module1"
' Daniel Carpenter Personal Excel Macros for Formatting and other Repeated functions


Sub FormatInput()
Attribute FormatInput.VB_ProcData.VB_Invoke_Func = "I\n14"
'
' FormatInput Macro
'
' Keyboard Shortcut: Ctrl+Shift+I
'
    Selection.Style = "Input"
End Sub
Sub FormatOutput()
Attribute FormatOutput.VB_ProcData.VB_Invoke_Func = "O\n14"
'
' FormatOutput Macro
'
' Keyboard Shortcut: Ctrl+Shift+O
'
    Selection.Style = "Output"
End Sub


Sub SnaptoGrid()
Attribute SnaptoGrid.VB_ProcData.VB_Invoke_Func = "G\n14"
'
' SnaptoGrid Macro
'
' Keyboard Shortcut: Ctrl+Shift+G
'
Application.CommandBars.FindControl(ID:=549).Execute
End Sub

Sub PivotTableAnalysis()
'
' PivotTableAnalysis Macro
'
    Dim St As Worksheet
    Dim NewSt As Worksheet
    Dim pt As PivotTable
    Dim i, K As Long
    Application.ScreenUpdating = False
    Set NewSt = Worksheets.Add
    i = 1: K = 2
    With NewSt
        .Cells(i, 1) = "Name"
        .Cells(i, 2) = "Source"
        .Cells(i, 3) = "Refreshed by"
        .Cells(i, 4) = "Refreshed"
        .Cells(i, 5) = "Sheet"
        .Cells(i, 6) = "Location"
        For Each St In ActiveWorkbook.Worksheets
            For Each pt In St.PivotTables
                i = i + 1
                .Cells(i, 1).Value = pt.Name
                .Cells(i, 2).Value = pt.SourceData
                .Cells(i, 3).Value = pt.RefreshName
                .Cells(i, 4).Value = pt.RefreshDate
                .Cells(i, 5).Value = St.Name
                .Cells(i, 6).Value = pt.TableRange1.Address
            Next
        Next
        .Activate
    End With
    Application.ScreenUpdating = True
'
End Sub

Sub FormatDateShort()
Attribute FormatDateShort.VB_ProcData.VB_Invoke_Func = "D\n14"
'
' FormatDateShort Macro
'
' Keyboard Shortcut: Ctrl+Shift+D
'
    Selection.NumberFormat = "m/d/yyyy"
End Sub


Sub PivotTableErrors()
'
' PivotTableErrors Macro
'
'
' ListPivotTables Macro
'
Dim ws As Worksheet
Dim wsSD As Worksheet
Dim lstSD As ListObject
Dim pt As PivotTable
Dim rngPT As Range
Dim wsPL As Worksheet
Dim rngSD As Range
Dim rngHead As Range
Dim pt2 As PivotTable
Dim rngPT2 As Range
Dim rCols As Range
Dim rRows As Range
Dim RowPL As Long
Dim RptCols As Long
Dim SDCols As Long
Dim SDHead As Long
Dim lBang As Long
Dim nm As Name
Dim strSD As String
Dim strRefRC As String
Dim strRef As String
Dim strWS As String
Dim strAdd As String
Dim strFix As String
Dim lRowsInt As Long
Dim lColsInt As Long
Dim CountPT As Long
On Error Resume Next

RptCols = 13
RowPL = 2

For Each ws In ActiveWorkbook.Worksheets
  For Each pt In ws.PivotTables
    CountPT = CountPT + 1
    If CountPT > 0 Then Exit For
  Next pt
  If CountPT > 0 Then Exit For
Next ws

If CountPT = 0 Then
  MsgBox "No pivot tables in this workbook"
  GoTo exitHandler
End If

Set wsPL = Worksheets.Add

With wsPL
  .Range(.Cells(1, 1), .Cells(1, RptCols)).Value _
    = Array("Worksheet", _
        "Ws PTs", _
        "PT Name", _
        "PT Range", _
        "PTs Same Rows", _
        "PTs Same Cols", _
        "PivotCache", _
        "Source Data", _
        "Records", _
        "Data Cols", _
        "Data Heads", _
        "Head Fix", _
        "Refreshed")
End With

For Each ws In ActiveWorkbook.Worksheets
  For Each pt In ws.PivotTables
    lRowsInt = 0
    lColsInt = 0
    Set rngPT = pt.TableRange2
      
    For Each pt2 In ws.PivotTables
      If pt2.Name <> pt.Name Then
        Set rngPT2 = pt2.TableRange2
        Set rRows = Intersect(rngPT.Rows.EntireRow, _
            rngPT2.Rows.EntireRow)
        If Not rRows Is Nothing Then
          lRowsInt = lRowsInt + 1
        End If
        Set rCols = Intersect(rngPT.Columns.EntireColumn, _
            rngPT2.Columns.EntireColumn)
        If Not rCols Is Nothing Then
          lColsInt = lColsInt + 1
        End If
      End If
    Next pt2
    
    If pt.PivotCache.SourceType = 1 Then  'xlDatabase
      Set nm = Nothing
      strSD = ""
      strAdd = ""
      strFix = ""
      SDCols = 0
      SDHead = 0
      Set rngHead = Nothing
      Set lstSD = Nothing
      
      strSD = pt.SourceData
      
      'worksheet range?
      lBang = InStr(1, strSD, "!")
      If lBang > 0 Then
        strWS = Left(strSD, lBang - 1)
        strRefRC = Right(strSD, Len(strSD) - lBang)
        strRef = Application.ConvertFormula( _
              strRefRC, xlR1C1, xlA1)
        Set rngSD = Worksheets(strWS).Range(strRef)
        SDCols = rngSD.Columns.Count
        Set rngHead = rngSD.Rows(1)
        SDHead = WorksheetFunction.CountA(rngHead)
        GoTo AddToList
      End If
      
      'named range?
      Set nm = ThisWorkbook.Names(strSD)
      If Not nm Is Nothing Then
        strAdd = nm.RefersToRange.Address
        SDCols = nm.RefersToRange.Columns.Count
        Set rngHead = nm.RefersToRange.Rows(1)
        SDHead = WorksheetFunction.CountA(rngHead)
        GoTo AddToList
      End If
      
      'list object?
        For Each wsSD In ActiveWorkbook.Worksheets
          Set lstSD = wsSD.ListObjects(strSD)
          If Not lstSD Is Nothing Then
            strAdd = lstSD.Range.Address
            SDCols = lstSD.Range.Columns.Count
            Set rngHead = lstSD.HeaderRowRange
            SDHead = WorksheetFunction.CountA(rngHead)
            GoTo AddToList
          End If
        Next
    End If
    
AddToList:
     If SDCols <> SDHead Then strFix = "X"
     With wsPL
        .Range(.Cells(RowPL, 1), _
            .Cells(RowPL, RptCols)).Value _
          = Array(ws.Name, _
              ws.PivotTables.Count, _
              pt.Name, _
              pt.TableRange2.Address, _
              lRowsInt, _
              lColsInt, _
              pt.CacheIndex, _
              pt.SourceData, _
              pt.PivotCache.RecordCount, _
              SDCols, _
              SDHead, _
              strFix, _
              pt.PivotCache.RefreshDate)
        'add hyperlink to pt range
        .Hyperlinks.Add _
            Anchor:=.Cells(RowPL, 4), _
            Address:="", _
            SubAddress:="'" & ws.Name _
                & "'!" & pt.TableRange2.Address, _
            ScreenTip:=pt.TableRange2.Address, _
            TextToDisplay:=pt.TableRange2.Address
      End With

     RowPL = RowPL + 1
   Next pt
Next ws

With wsPL
  .Rows(1).Font.Bold = True
  .Range(.Cells(1, 1), .Cells(1, RptCols)) _
      .EntireColumn.AutoFit
End With

exitHandler:
  Set wsPL = Nothing
  Set ws = Nothing
  Set pt = Nothing
  Exit Sub
End Sub


Sub RepeatRows()
'
' RepeatRows Macro
' [A=Desc; B=Loop#]
'
    Dim xRow As Long
    Dim VInSertNum As Variant
    xRow = 1
    Application.ScreenUpdating = False
    Do While (Cells(xRow, "A") <> "")
        VInSertNum = Cells(xRow, "B")
        If ((VInSertNum > 1) And IsNumeric(VInSertNum)) Then
           Range(Cells(xRow, "A"), Cells(xRow, "B")).Copy
           Range(Cells(xRow + 1, "A"), Cells(xRow + VInSertNum - 1, "B")).Select
           Selection.Insert Shift:=xlDown
           xRow = xRow + VInSertNum - 1
        End If
        xRow = xRow + 1
    Loop
    Application.ScreenUpdating = False
'
End Sub


Option Explicit

Sub ExportData()
'https://urldefense.com/v3/__http://www.howtoexcel.org/__;!!IMeFMrRG1GeY!PJlbv0Ma5IBVZPTNK5O4PL060aF4mYPcn9GgVIzok8Q5lEI8ZFzOqOmWwBhaevR5_PEhe2ds$
'John MacDougall 2017-05-07

'Declare variables
Dim ArrayItem As Long
Dim ws As Worksheet
Dim ArrayOfUniqueValues As Variant
Dim SavePath As String
Dim ColumnHeadingInt As Long
Dim ColumnHeadingStr As String
Dim rng As Range

'Set the worksheet to
Set ws = Sheets("Data")

'Set the save path for the files created
SavePath = Range("FolderPath")

'Set variables for the column we want to separate data based on
ColumnHeadingInt = WorksheetFunction.Match(Range("ExportCriteria").Value, Range("Data[#Headers]"), 0)
ColumnHeadingStr = "Data[[#All],[" & Range("ExportCriteria").Value & "]]"

'Turn off screen updating to save runtime
Application.ScreenUpdating = False

'Create a temporary list of unique values from the column we want to
'separate our data based on
Range(ColumnHeadingStr & "").AdvancedFilter Action:=xlFilterCopy, _
    CopyToRange:=Range("UniqueValues"), Unique:=True

'Sort our temporary list of unique values
ws.Range("UniqueValues").EntireColumn.Sort Key1:=ws.Range("UniqueValues").Offset(1, 0), _
    Order1:=xlAscending, Header:=xlYes, OrderCustom:=1, MatchCase:=False, _
    Orientation:=xlTopToBottom, DataOption1:=xlSortNormal

'Add unique field values into an array
'ArrayOfUniqueValues = Application.WorksheetFunction.Transpose(ws.Range("IV2:IV" & Rows.Count).SpecialCells(xlCellTypeConstants))
ArrayOfUniqueValues = Application.WorksheetFunction.Transpose(ws.Range("UniqueValues").EntireColumn.SpecialCells(xlCellTypeConstants))

'Delete the temporary values
ws.Range("UniqueValues").EntireColumn.Clear

'Loop through our array of unique field values, copy paste into new workbooks and save
For ArrayItem = 1 To UBound(ArrayOfUniqueValues)
    ws.ListObjects("Data").Range.AutoFilter field:=ColumnHeadingInt, Criteria1:=ArrayOfUniqueValues(ArrayItem)
    ws.Range("Data[#All]").SpecialCells(xlCellTypeVisible).Copy
    Workbooks.Add
    Range("A1").PasteSpecial xlPasteAll
    Worksheets("Sheet1").Range("A1:E500").Columns.AutoFit
    ActiveWorkbook.SaveAs SavePath & ArrayOfUniqueValues(ArrayItem) & ".xlsx", 51
    ActiveWorkbook.Close False
    ws.ListObjects("Data").Range.AutoFilter field:=ColumnHeadingInt
Next ArrayItem

ws.AutoFilterMode = False
MsgBox "Finished exporting!"
Application.ScreenUpdating = True
    
End Sub


Sub splitColtoWs()
    Dim lr As Long
    Dim ws As Worksheet
    Dim vcol, i As Integer
    Dim icol As Long
    Dim myarr As Variant
    Dim title As String
    Dim titlerow As Integer

    'This macro splits data into multiple worksheets based on the variables on a column found in Excel.
    'An InputBox asks you which columns you'd like to filter by, and it just creates these worksheets.

    Application.ScreenUpdating = False
    vcol = Application.InputBox(prompt:="Which column would you like to filter by?", title:="Filter column", Default:="3", Type:=1)
    Set ws = ActiveSheet
    lr = ws.Cells(ws.Rows.Count, vcol).End(xlUp).Row
    title = "A1"
    titlerow = ws.Range(title).Cells(1).Row
    icol = ws.Columns.Count
    ws.Cells(1, icol) = "Unique"
    For i = 2 To lr
        On Error Resume Next
        If ws.Cells(i, vcol) <> "" And Application.WorksheetFunction.Match(ws.Cells(i, vcol), ws.Columns(icol), 0) = 0 Then
            ws.Cells(ws.Rows.Count, icol).End(xlUp).Offset(1) = ws.Cells(i, vcol)
        End If
    Next

    myarr = Application.WorksheetFunction.Transpose(ws.Columns(icol).SpecialCells(xlCellTypeConstants))
    ws.Columns(icol).Clear

    For i = 2 To UBound(myarr)
        ws.Range(title).AutoFilter field:=vcol, Criteria1:=myarr(i) & ""
        If Not Evaluate("=ISREF('" & myarr(i) & "'!A1)") Then
            Sheets.Add(after:=Worksheets(Worksheets.Count)).Name = myarr(i) & ""
        Else
            Sheets(myarr(i) & "").Move after:=Worksheets(Worksheets.Count)
        End If
        ws.Range("A" & titlerow & ":A" & lr).EntireRow.Copy Sheets(myarr(i) & "").Range("A1")
        'Sheets(myarr(i) & "").Columns.AutoFit
    Next

    ws.AutoFilterMode = False
    ws.Activate
    Application.ScreenUpdating = True
End Sub


Sub FormatBlueHeaderHighlight()
Attribute FormatBlueHeaderHighlight.VB_ProcData.VB_Invoke_Func = "H\n14"
'
' BlueHeaderHighlight Macro
'
' Keyboard Shortcut: Ctrl+Shift+H
'
    With Selection.Interior
        .Pattern = xlSolid
        .PatternColorIndex = xlAutomatic
        .ThemeColor = xlThemeColorAccent1
        .TintAndShade = 0.799981688894314
        .PatternTintAndShade = 0
    End With
    Selection.Borders(xlDiagonalDown).LineStyle = xlNone
    Selection.Borders(xlDiagonalUp).LineStyle = xlNone
    Selection.Borders(xlEdgeLeft).LineStyle = xlNone
    Selection.Borders(xlEdgeTop).LineStyle = xlNone
    With Selection.Borders(xlEdgeBottom)
        .LineStyle = xlContinuous
        .ThemeColor = 5
        .TintAndShade = 0.399945066682943
        .Weight = xlThin
    End With
    Selection.Borders(xlEdgeRight).LineStyle = xlNone
    Selection.Borders(xlInsideVertical).LineStyle = xlNone
    Selection.Borders(xlInsideHorizontal).LineStyle = xlNone
    With Selection
        .HorizontalAlignment = xlCenter
        .VerticalAlignment = xlBottom
        .WrapText = True
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
        .MergeCells = False
    End With
    Selection.Font.Bold = True
    With Selection.Font
        .ColorIndex = xlAutomatic
        .TintAndShade = 0
    End With
End Sub
Sub FormatDarkBlueHeader()
Attribute FormatDarkBlueHeader.VB_ProcData.VB_Invoke_Func = "S\n14"
'
' FormatDarkBlueHeader Macro
'
' Keyboard Shortcut: Ctrl+Shift+S
'
    With Selection.Interior
        .Pattern = xlSolid
        .PatternColorIndex = xlAutomatic
        .ThemeColor = xlThemeColorAccent1
        .TintAndShade = -0.499984740745262
        .PatternTintAndShade = 0
    End With
    With Selection.Font
        .ThemeColor = xlThemeColorDark1
        .TintAndShade = 0
    End With
    Selection.Font.Bold = True
    With Selection
        .HorizontalAlignment = xlCenterAcrossSelection
        .VerticalAlignment = xlBottom
        .WrapText = True
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
        .MergeCells = False
    End With
End Sub
Sub FormatBlueFooterHighlight()
Attribute FormatBlueFooterHighlight.VB_ProcData.VB_Invoke_Func = "F\n14"
'
' FormatBlueFooterHighlight Macro
'
' Keyboard Shortcut: Ctrl+Shift+F
'
    With Selection.Interior
        .Pattern = xlSolid
        .PatternColorIndex = xlAutomatic
        .ThemeColor = xlThemeColorAccent1
        .TintAndShade = 0.799981688894314
        .PatternTintAndShade = 0
    End With
    With Selection.Font
        .ColorIndex = xlAutomatic
        .TintAndShade = 0
    End With
    With Selection
        .HorizontalAlignment = xlGeneral
        .VerticalAlignment = xlBottom
        .WrapText = False
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
        .MergeCells = False
    End With
    Selection.Font.Bold = True
    Selection.Borders(xlDiagonalDown).LineStyle = xlNone
    Selection.Borders(xlDiagonalUp).LineStyle = xlNone
    Selection.Borders(xlEdgeLeft).LineStyle = xlNone
    With Selection.Borders(xlEdgeTop)
        .LineStyle = xlContinuous
        .ThemeColor = 5
        .TintAndShade = 0.399945066682943
        .Weight = xlThin
    End With
    Selection.Borders(xlEdgeBottom).LineStyle = xlNone
    Selection.Borders(xlEdgeRight).LineStyle = xlNone
    Selection.Borders(xlInsideVertical).LineStyle = xlNone
    Selection.Borders(xlInsideHorizontal).LineStyle = xlNone
End Sub




Sub UnhideAllSheets()

'Unhide all sheets in workbook.

Dim ws As Worksheet
    
    For Each ws In ActiveWorkbook.Worksheets
        
        ws.Visible = xlSheetVisible
    
    Next ws

End Sub

Sub FormatInterierBorders()
Attribute FormatInterierBorders.VB_ProcData.VB_Invoke_Func = "N\n14"
'
' FormatInterierBorders Macro
'
' Keyboard Shortcut: Ctrl+Shift+N
'
    Selection.Borders(xlDiagonalDown).LineStyle = xlNone
    Selection.Borders(xlDiagonalUp).LineStyle = xlNone
    With Selection.Borders(xlEdgeLeft)
        .LineStyle = xlContinuous
        .ThemeColor = 1
        .TintAndShade = -0.149937437055574
        .Weight = xlThin
    End With
    With Selection.Borders(xlEdgeTop)
        .LineStyle = xlContinuous
        .ThemeColor = 5
        .TintAndShade = 0.399945066682943
        .Weight = xlThin
    End With
    With Selection.Borders(xlEdgeBottom)
        .LineStyle = xlContinuous
        .ThemeColor = 1
        .TintAndShade = -0.149937437055574
        .Weight = xlThin
    End With
    With Selection.Borders(xlEdgeRight)
        .LineStyle = xlContinuous
        .ThemeColor = 1
        .TintAndShade = -0.149937437055574
        .Weight = xlThin
    End With
    With Selection.Borders(xlInsideVertical)
        .LineStyle = xlContinuous
        .ThemeColor = 1
        .TintAndShade = -0.14996795556505
        .Weight = xlThin
    End With
    With Selection.Borders(xlInsideHorizontal)
        .LineStyle = xlContinuous
        .ThemeColor = 1
        .TintAndShade = -0.14996795556505
        .Weight = xlThin
    End With
End Sub

Sub FormatGreyBottom()
Attribute FormatGreyBottom.VB_ProcData.VB_Invoke_Func = "B\n14"
'
' FormatGreyBottom Macro
'
' Keyboard Shortcut: Ctrl+Shift+B
'
    With Selection.Interior
        .Pattern = xlSolid
        .PatternColorIndex = xlAutomatic
        .Color = 15921906
        .TintAndShade = 0
        .PatternTintAndShade = 0
    End With
    Selection.Font.Bold = False
    Selection.Font.Bold = True
    With Selection.Font
        .Color = -12632257
        .TintAndShade = 0
    End With
    Selection.Borders(xlDiagonalDown).LineStyle = xlNone
    Selection.Borders(xlDiagonalUp).LineStyle = xlNone
    Selection.Borders(xlEdgeLeft).LineStyle = xlNone
    With Selection.Borders(xlEdgeTop)
        .LineStyle = xlContinuous
        .ThemeColor = 2
        .TintAndShade = 0.499984740745262
        .Weight = xlThin
    End With
    With Selection.Borders(xlEdgeBottom)
        .LineStyle = xlContinuous
        .ThemeColor = 2
        .TintAndShade = 0.499984740745262
        .Weight = xlThin
    End With
    Selection.Borders(xlEdgeRight).LineStyle = xlNone
    Selection.Borders(xlInsideVertical).LineStyle = xlNone
    Selection.Borders(xlInsideHorizontal).LineStyle = xlNone
End Sub



Sub FormatCenterAccrossSelection()
Attribute FormatCenterAccrossSelection.VB_ProcData.VB_Invoke_Func = "C\n14"
'
' FormatCenterAccrossSelection Macro
'
' Keyboard Shortcut: Ctrl+Shift+C
'
    With Selection
        .HorizontalAlignment = xlCenterAcrossSelection
        .VerticalAlignment = xlBottom
        .WrapText = False
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
        .MergeCells = False
    End With

End Sub
Sub FormatAccounting()
Attribute FormatAccounting.VB_ProcData.VB_Invoke_Func = "A\n14"
'
' FormatAccounting Macro
'
' Keyboard Shortcut: Ctrl+Shift+A
'
    Selection.Style = "Comma"
    Selection.NumberFormat = "_(* #,##0.0_);_(* (#,##0.0);_(* ""-""??_);_(@_)"
    Selection.NumberFormat = "_(* #,##0_);_(* (#,##0);_(* ""-""??_);_(@_)"
End Sub

