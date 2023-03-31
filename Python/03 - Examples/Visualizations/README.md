# Starter Code and Example for a Sankey Flow Diagram

## Packages


```python
import pandas as pd
import plotly.graph_objects as go
```

## Data Import


```python
filePath = ""
excelFileName = "Data.xlsx"

nodesSheetName = 'Nodes'
linksSheetName = 'Links'

# Read in nodes data
node_df = pd.read_excel(filePath + excelFileName, sheet_name=nodesSheetName, engine='openpyxl')

# Read in link data
link_df = pd.read_excel(filePath + excelFileName, sheet_name=linksSheetName, engine='openpyxl')
```

## Inputs to Chart Aesthetics


```python
# File name to and dimensions when exporting chart
outputFileName = 'Sankey Diagram Example Output'
outHeight = 900
outWidth  = 1600

# Node parameters
nodeTextSize  = 12
nodePad       = 10
nodeThickness = 15
nodeLine      = dict(width=0)

# Graph parameters

## Title
titleText       = 'Sankey Diagram of Revenue and Expenses'
titleFontSize   = 24

## Caption
captionText     = 'Caption'
captionFontSize = 16
textFontSize    = 16

## General Fonts
fontFamily      = 'Times New Roman'
fontColor       = '#585858'
paperBgcolor    = 'rgba(0,0,0,0)'
plotBgcolor     = 'rgba(0,0,0,0)'

# Tool tip parameters
linkHoverTemplate = '%{source.label} → %{target.label}<br>$%{value:,.2f} M'
nodeHoverTemplate = f'<span style="font-family:{fontFamily}; font-size:{nodeTextSize}px;">%{{label}}<br>$%{{value:,.2f}} M</span>'

# Positions of the x and y axis of nodes
MAX_X_POSITION = 0.9
MAX_Y_POSITION = 0.5
cols = [0, MAX_X_POSITION*(0.5), MAX_X_POSITION]
rows = [(-2)*MAX_Y_POSITION, MAX_Y_POSITION*(0.5), MAX_Y_POSITION]
```

## Create the Graph


```python
# NODES ----------------------------------------------------------------

# Node Labels
NodeLabel =  [f"{node}: ${value} M" for (node, value) in zip(node_df['Node'], node_df['Value']) ]
node_df['Label'] = NodeLabel


# Node positions
numRows = len(rows)
numCols = len(cols)

colPositions = [cols[0]] + [cols[i] for i in range(1, numCols) ]*numCols
colPositions.sort()

node_df['node_position_x'] = colPositions
node_df['node_position_y'] = [0] + rows*(numRows-1)


# Create dictionary for nodes
nodes = dict(
    type='sankey',
    orientation='h',
    arrangement='snap',
    node=dict(
        pad=nodePad,
        thickness=nodeThickness,
        line=nodeLine,
        label=node_df['Label'],
        color=node_df['Color'],
        x=node_df['node_position_x'],
        y=node_df['node_position_y'],
        hovertemplate=nodeHoverTemplate
    )
)


# LINKS ---------------------------------------------------------------------

# Convert node labels to node indices
source_indices = [node_df[node_df['Node'] == source].index[0] for source in link_df['Source']]
target_indices = [node_df[node_df['Node'] == target].index[0] for target in link_df['Target']]

# Create dictionary for links
link_dict = dict(
    source=source_indices,
    target=target_indices,
    value=link_df['Value'],
    color=link_df['Color'],
    hovertemplate=linkHoverTemplate,
    hoverlabel=dict(font=dict(family=fontFamily))
)

# Define nodes and links
nodes['link'] = link_dict



# CHART LAYOUT ------------------------------------------------------------

# Define layout
layout = dict(
    title=dict(
        text=titleText,
        font=dict(size=titleFontSize, family=fontFamily, color=fontColor),
        x=0,
        xanchor='left',
        yanchor='top'
    ),
    annotations=[
        dict(
            text=captionText,
            showarrow=False,
            font=dict(size=captionFontSize, family=fontFamily, color=fontColor),
            xref='paper',
            yref='paper',
            x=0,
            y=-0.1,
            xanchor='left',
            yanchor='bottom'
        )
    ],
    paper_bgcolor=paperBgcolor,
    plot_bgcolor=plotBgcolor,
    font=dict(size=textFontSize, family=fontFamily, color=fontColor)
)

# Create figure
fig = go.Figure(data=[nodes], layout=layout)

# Show figure
fig.show()

# Export to PNG
fig.write_image(outputFileName + ".png", height=outHeight, width=outWidth)
```


<div>                            <div id="24a1d773-b8c2-48fd-b55d-bcf102967e62" class="plotly-graph-div" style="height:525px; width:100%;"></div>            <script type="text/javascript">                require(["plotly"], function(Plotly) {                    window.PLOTLYENV=window.PLOTLYENV || {};                                    if (document.getElementById("24a1d773-b8c2-48fd-b55d-bcf102967e62")) {                    Plotly.newPlot(                        "24a1d773-b8c2-48fd-b55d-bcf102967e62",                        [{"arrangement":"snap","link":{"color":["#BECDE0","#BECDE0","#BECDE0","#F6B7B4","#F6B7B4","#F6B7B4"],"hoverlabel":{"font":{"family":"Times New Roman"}},"hovertemplate":"%{source.label} \u2192 %{target.label}<br>$%{value:,.2f} M","source":[0,0,0,1,1,1],"target":[2,3,1,4,5,6],"value":[200,100,700,500,100,100]},"node":{"color":["#6388B4","#EB4B43","#6388B4","#6388B4","#EB4B43","#EB4B43","#EB4B43"],"hovertemplate":"<span style=\"font-family:Times New Roman; font-size:12px;\">%{label}<br>$%{value:,.2f} M</span>","label":["Revenue: $1000 M","Operating Expenses: $700 M","COGS: $200 M","Taxes: $100 M","SG&A: $500 M","Licenses & Fees: $100 M","Other: $100 M"],"line":{"width":0},"pad":10,"thickness":15,"x":[0.0,0.45,0.45,0.45,0.9,0.9,0.9],"y":[0.0,-1.0,0.25,0.5,-1.0,0.25,0.5]},"orientation":"h","type":"sankey"}],                        {"annotations":[{"font":{"color":"#585858","family":"Times New Roman","size":16},"showarrow":false,"text":"Caption","x":0,"xanchor":"left","xref":"paper","y":-0.1,"yanchor":"bottom","yref":"paper"}],"font":{"color":"#585858","family":"Times New Roman","size":16},"paper_bgcolor":"rgba(0,0,0,0)","plot_bgcolor":"rgba(0,0,0,0)","title":{"font":{"color":"#585858","family":"Times New Roman","size":24},"text":"Sankey Diagram of Revenue and Expenses","x":0,"xanchor":"left","yanchor":"top"},"template":{"data":{"histogram2dcontour":[{"type":"histogram2dcontour","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"choropleth":[{"type":"choropleth","colorbar":{"outlinewidth":0,"ticks":""}}],"histogram2d":[{"type":"histogram2d","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"heatmap":[{"type":"heatmap","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"heatmapgl":[{"type":"heatmapgl","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"contourcarpet":[{"type":"contourcarpet","colorbar":{"outlinewidth":0,"ticks":""}}],"contour":[{"type":"contour","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"surface":[{"type":"surface","colorbar":{"outlinewidth":0,"ticks":""},"colorscale":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]]}],"mesh3d":[{"type":"mesh3d","colorbar":{"outlinewidth":0,"ticks":""}}],"scatter":[{"fillpattern":{"fillmode":"overlay","size":10,"solidity":0.2},"type":"scatter"}],"parcoords":[{"type":"parcoords","line":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scatterpolargl":[{"type":"scatterpolargl","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"bar":[{"error_x":{"color":"#2a3f5f"},"error_y":{"color":"#2a3f5f"},"marker":{"line":{"color":"#E5ECF6","width":0.5},"pattern":{"fillmode":"overlay","size":10,"solidity":0.2}},"type":"bar"}],"scattergeo":[{"type":"scattergeo","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scatterpolar":[{"type":"scatterpolar","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"histogram":[{"marker":{"pattern":{"fillmode":"overlay","size":10,"solidity":0.2}},"type":"histogram"}],"scattergl":[{"type":"scattergl","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scatter3d":[{"type":"scatter3d","line":{"colorbar":{"outlinewidth":0,"ticks":""}},"marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scattermapbox":[{"type":"scattermapbox","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scatterternary":[{"type":"scatterternary","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"scattercarpet":[{"type":"scattercarpet","marker":{"colorbar":{"outlinewidth":0,"ticks":""}}}],"carpet":[{"aaxis":{"endlinecolor":"#2a3f5f","gridcolor":"white","linecolor":"white","minorgridcolor":"white","startlinecolor":"#2a3f5f"},"baxis":{"endlinecolor":"#2a3f5f","gridcolor":"white","linecolor":"white","minorgridcolor":"white","startlinecolor":"#2a3f5f"},"type":"carpet"}],"table":[{"cells":{"fill":{"color":"#EBF0F8"},"line":{"color":"white"}},"header":{"fill":{"color":"#C8D4E3"},"line":{"color":"white"}},"type":"table"}],"barpolar":[{"marker":{"line":{"color":"#E5ECF6","width":0.5},"pattern":{"fillmode":"overlay","size":10,"solidity":0.2}},"type":"barpolar"}],"pie":[{"automargin":true,"type":"pie"}]},"layout":{"autotypenumbers":"strict","colorway":["#636efa","#EF553B","#00cc96","#ab63fa","#FFA15A","#19d3f3","#FF6692","#B6E880","#FF97FF","#FECB52"],"font":{"color":"#2a3f5f"},"hovermode":"closest","hoverlabel":{"align":"left"},"paper_bgcolor":"white","plot_bgcolor":"#E5ECF6","polar":{"bgcolor":"#E5ECF6","angularaxis":{"gridcolor":"white","linecolor":"white","ticks":""},"radialaxis":{"gridcolor":"white","linecolor":"white","ticks":""}},"ternary":{"bgcolor":"#E5ECF6","aaxis":{"gridcolor":"white","linecolor":"white","ticks":""},"baxis":{"gridcolor":"white","linecolor":"white","ticks":""},"caxis":{"gridcolor":"white","linecolor":"white","ticks":""}},"coloraxis":{"colorbar":{"outlinewidth":0,"ticks":""}},"colorscale":{"sequential":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]],"sequentialminus":[[0.0,"#0d0887"],[0.1111111111111111,"#46039f"],[0.2222222222222222,"#7201a8"],[0.3333333333333333,"#9c179e"],[0.4444444444444444,"#bd3786"],[0.5555555555555556,"#d8576b"],[0.6666666666666666,"#ed7953"],[0.7777777777777778,"#fb9f3a"],[0.8888888888888888,"#fdca26"],[1.0,"#f0f921"]],"diverging":[[0,"#8e0152"],[0.1,"#c51b7d"],[0.2,"#de77ae"],[0.3,"#f1b6da"],[0.4,"#fde0ef"],[0.5,"#f7f7f7"],[0.6,"#e6f5d0"],[0.7,"#b8e186"],[0.8,"#7fbc41"],[0.9,"#4d9221"],[1,"#276419"]]},"xaxis":{"gridcolor":"white","linecolor":"white","ticks":"","title":{"standoff":15},"zerolinecolor":"white","automargin":true,"zerolinewidth":2},"yaxis":{"gridcolor":"white","linecolor":"white","ticks":"","title":{"standoff":15},"zerolinecolor":"white","automargin":true,"zerolinewidth":2},"scene":{"xaxis":{"backgroundcolor":"#E5ECF6","gridcolor":"white","linecolor":"white","showbackground":true,"ticks":"","zerolinecolor":"white","gridwidth":2},"yaxis":{"backgroundcolor":"#E5ECF6","gridcolor":"white","linecolor":"white","showbackground":true,"ticks":"","zerolinecolor":"white","gridwidth":2},"zaxis":{"backgroundcolor":"#E5ECF6","gridcolor":"white","linecolor":"white","showbackground":true,"ticks":"","zerolinecolor":"white","gridwidth":2}},"shapedefaults":{"line":{"color":"#2a3f5f"}},"annotationdefaults":{"arrowcolor":"#2a3f5f","arrowhead":0,"arrowwidth":1},"geo":{"bgcolor":"white","landcolor":"#E5ECF6","subunitcolor":"white","showland":true,"showlakes":true,"lakecolor":"white"},"title":{"x":0.05},"mapbox":{"style":"light"}}}},                        {"responsive": true}                    ).then(function(){

var gd = document.getElementById('24a1d773-b8c2-48fd-b55d-bcf102967e62');
var x = new MutationObserver(function (mutations, observer) {{
        var display = window.getComputedStyle(gd).display;
        if (!display || display === 'none') {{
            console.log([gd, 'removed!']);
            Plotly.purge(gd);
            observer.disconnect();
        }}
}});

// Listen for the removal of the full notebook cells
var notebookContainer = gd.closest('#notebook-container');
if (notebookContainer) {{
    x.observe(notebookContainer, {childList: true});
}}

// Listen for the clearing of the current output cell
var outputEl = gd.closest('.output');
if (outputEl) {{
    x.observe(outputEl, {childList: true});
}}

                        })                };                });            </script>        </div>



    ---------------------------------------------------------------------------

    NameError                                 Traceback (most recent call last)

    C:\Users\DANIEL~1.CAR\AppData\Local\Temp/ipykernel_17540/3633035441.py in <module>
         93 # Export to PNG
         94 fig.write_image(outputFileName + ".png",
    ---> 95                     height=outHeight, width=outWidth)
    

    NameError: name 'outHeight' is not defined

