Udemy Notes: Mastering Data Visualization: Theory and Foundations
================
Daniel Carpenter
Jul 2023

- <a href="#overview" id="toc-overview"><span
  class="toc-section-number">1</span> Overview</a>
- <a href="#graphical-perception" id="toc-graphical-perception"><span
  class="toc-section-number">2</span> Graphical Perception</a>
  - <a href="#how-do-users-interpret-the-main-dimensions"
    id="toc-how-do-users-interpret-the-main-dimensions"><span
    class="toc-section-number">2.1</span> <strong>How do users interpret the
    main dimensions?</strong></a>
  - <a href="#how-to-redesign-bad-visuals"
    id="toc-how-to-redesign-bad-visuals"><span
    class="toc-section-number">2.2</span> How to redesign bad visuals?</a>
- <a href="#golden-rules-of-data-visualization"
  id="toc-golden-rules-of-data-visualization"><span
  class="toc-section-number">3</span> Golden Rules of Data
  Visualization</a>
  - <a href="#dimensions" id="toc-dimensions"><span
    class="toc-section-number">3.1</span> Dimensions</a>
  - <a href="#how-to-limit-distractions"
    id="toc-how-to-limit-distractions"><span
    class="toc-section-number">3.2</span> How to limit distractions</a>
  - <a href="#data-density" id="toc-data-density"><span
    class="toc-section-number">3.3</span> Data Density</a>
  - <a href="#proportion-and-scale" id="toc-proportion-and-scale"><span
    class="toc-section-number">3.4</span> Proportion and Scale</a>
  - <a href="#other" id="toc-other"><span
    class="toc-section-number">3.5</span> Other</a>
- <a href="#statistical-traps" id="toc-statistical-traps"><span
  class="toc-section-number">4</span> Statistical Traps</a>
- <a href="#correct-plot-usage" id="toc-correct-plot-usage"><span
  class="toc-section-number">5</span> Correct Plot Usage</a>
  - <a href="#distributions" id="toc-distributions"><span
    class="toc-section-number">5.1</span> Distributions</a>
  - <a href="#relationships" id="toc-relationships"><span
    class="toc-section-number">5.2</span> Relationships</a>
  - <a href="#ranking" id="toc-ranking"><span
    class="toc-section-number">5.3</span> Ranking</a>
  - <a href="#part-of-whole" id="toc-part-of-whole"><span
    class="toc-section-number">5.4</span> Part of Whole</a>
- <a href="#plot-crimes" id="toc-plot-crimes"><span
  class="toc-section-number">6</span> Plot Crimes</a>
  - <a href="#avoiding-noise" id="toc-avoiding-noise"><span
    class="toc-section-number">6.1</span> Avoiding Noise</a>
  - <a href="#choosing-color" id="toc-choosing-color"><span
    class="toc-section-number">6.2</span> Choosing Color</a>
  - <a href="#section" id="toc-section"><span
    class="toc-section-number">6.3</span> </a>

[*Link to Udemy Class
here*](https://www.udemy.com/course/mastering-data-visualization)

# Overview

- Use “ink” only where you have data (density vs. line area)

- Remove elements if there is no information lost

- Proportions matter: Smaller plots are okay because it focuses the eye

- Highlight single element and gray the rest if that is the message

# Graphical Perception

## **How do users interpret the main dimensions?**

| Type                             | Easy to Hard Rank | Digestability                                                                                                                            | Avoid                                                                                                      |
|----------------------------------|-------------------|------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------------------------------------|
| **Position with common scale**   | 1                 | Easy                                                                                                                                     |                                                                                                            |
| **Position in non-common scale** | 2                 | Hard, especially when adjacent.                                                                                                          | small multiples with multiple rows without constant scale                                                  |
| **Length**                       | 3                 | Easy when aligned. otherwise not.                                                                                                        | Wide bar charts or widths of bars that are uneven                                                          |
| **Direction**                    | 3                 | Easy if aligned with same length. otherwise not.                                                                                         | Try not to mix with uneven position and length                                                             |
| **Angle**                        | 3                 | Hard to encode especially when making rotated comparisons                                                                                | Pie charts                                                                                                 |
| **Area**                         | 4                 | Circular area has a non-linear relationship, so very difficult to compare two bubbles of differing size                                  | Bubbles sparingly?                                                                                         |
| **Curvature**                    | 5                 | Brain wants to calculate the horizonal difference, not the vertical, which is correct                                                    | Line comparisons with function comparisons                                                                 |
| **Volume**                       | 5                 | Relationships are usually non-linear, so tend to expect a smaller change.                                                                | If a cube looks a little larger than another cube, it is likely more since a cube is $x^3$ compared to $x$ |
| **Color and Shading**            | 6                 | Interpretation of individual shade strongly depends on surrounding shading. Surrounding colors could cause misinterpretation or shading. | A county heat map could be hard to analyze one individual county, vs. the overall trend                    |

## How to redesign bad visuals?

> **Goal**: Identify visual elements involved, and reduce them to as
> little as possible while conveying same results.
>
> **Tradeoff**: sometimes more complex is better if it draws attention
> to goal of graph.

| Graph             | Elements Involved                           | Redesign         | Redesign Elements                           |
|-------------------|---------------------------------------------|------------------|---------------------------------------------|
| Pie               | Angle, direction, and area                  | Lollipop         | Position in common scale. Note *no length.* |
| Stacked Bar Chart | Length, position in non-common scale.       | Faceted Lollipop | Position in common scale                    |
| Shaded Map        | Area, shading, Position in non-common scale | Map with Peaks   | Position in non-common scale                |

------------------------------------------------------------------------

# Golden Rules of Data Visualization

## Dimensions

1.  The number of dimensions should $\leq$ the number of dimensions in
    the data (i.e., do not make it 3D, or add length, etc.)

2.  Do not use a dimension if you do not need it

3.  Do not use 3D unless it is something like a map

4.  Do not use color unless it means something

5.  Do not alter the perspective (orientation, angle, etc.)

### Dimension Questionnaire:

1.  Do you need it, or does it look nice?

2.  Are you showing the relationship or just trying to save space?

## How to limit distractions

1.  Identify what is absolutely essential for the graph
2.  Identify and remove what is not essential (including axis,
    gridlines, etc.).
3.  If using data labels, but the y axis title in the subtitle of the
    plot
4.  Stay away from dark borders

## Data Density

> Show as much as you can with the least amount of space, *within
> reason*
>
> It is okay to have a small plot because it emphasizes relationships.

## Proportion and Scale

- X-axis should almost always be longer than the y-axis

- Ratios: aim to have the lines in a graph have a 45-degree ratio

Ratio Recommendations:

- Wide infer you should read it horizontally (time series)

- Long infers vertically (heatmap)

- Square is none

## Other

- Don’t distort intentionally

- Annotations are good

- “Range frame” can help show where the coordinates are in a x-axis

------------------------------------------------------------------------

# Statistical Traps

- Selection Bias: “*What you see depends on where you look”*

- Attrition Bias: Inferences on data that has not happened yet

- Normalization: If normalizing, show both raw and normalized. Make sure
  to normalize if relevant.

- Simpson’s paradox: trends may exist in a subset of the data, but no
  trend when aggregated.

------------------------------------------------------------------------

# Correct Plot Usage

## Distributions

### Violin or Boxplots

- Order by median value.

- It is okay to overlay the two.

- Show sample size if largely different.

### Ridgeline

- If data is discrete, then use histogram not density

## Relationships

### Line/Area Charts

- If low amount of data points then use dots

- No area shading: Only shade areas IF it is a distribution.

- Never use a stacked area plot

## Ranking

- Always order

- Do not stack

- Lollipops over bars

- Dumbells for ranges

- Avoid word plots (many concepts violated)

### Parallel Plots

- Only use if patterns in data

- highlight changes in patterns with 2 colors

## Part of Whole

- Election cycle tracking has good examples

- Modern touches on bars

### Maps

- Use for the bigger picture trends, not for the detail

- Combine with other charts to help fill in the detail

- Remember that larger regions will cause distortion and get more weight

- Hexbin or cartograms could help account for distortion of area.

- Left/right arrows: vector field diagram.

------------------------------------------------------------------------

# Plot Crimes

<table style="width:99%;">
<colgroup>
<col style="width: 18%" />
<col style="width: 52%" />
<col style="width: 28%" />
</colgroup>
<thead>
<tr class="header">
<th>Crime</th>
<th>When it is good</th>
<th>When it is bad</th>
</tr>
</thead>
<tbody>
<tr class="odd">
<td>Cutting y-axis</td>
<td><ul>
<li><p>Compare relative positions in a time series within single
group</p></li>
<li><p>Line charts, dumbell charts</p></li>
</ul></td>
<td><ul>
<li><p>Comparing groups in bar charts.</p></li>
<li><p>If these are verticle lines</p></li>
<li><p>Bar charts</p></li>
<li><p>Shaded charts</p></li>
</ul></td>
</tr>
<tr class="even">
<td>When to shade an area?</td>
<td><ul>
<li>Shade only where you have data.</li>
</ul>
<!-- -->
<ul>
<li>I.e., Distributions</li>
</ul></td>
<td>Time series</td>
</tr>
</tbody>
</table>

## Avoiding Noise

1.  Highlight a single element and gray the rest

2.  Separate data into small multiples, but this could be hard to be
    adjacent. Keep a fixed scale

3.  Combine the two above

## Choosing Color

1.  Encode another variable (discrete message that shows a message).
2.  Reinforce the message (color the y axis on continuous scale).
3.  Do not conflict with your message.
4.  Try not to encode the most important variable with color.
5.  Be consistent with the same variable.
6.  Use human intuition if approproate
7.  Use `colorblindr` to see what the plot looks like in the color blind
    types

## 
