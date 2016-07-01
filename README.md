# LearnFlexboxLayout

参考资料： <https://blog.stylingandroid.com/flexboxlayout-part2/>

github项目地址： <https://github.com/google/flexbox-layout>


## **grade 依赖**

```
dependencies {  
compile 'com.google.android:flexbox:0.2.2'  
}
```


## **Flex 布局方式 概述**

flex 布局有很多属性，大概的布局方式如下图。
![flex图片](https://developer.mozilla.org/files/3739/flex_terms.png)

`flexlayout`布局中，子视图按照xml书写,或属性`layout_order`的数值顺序。沿主轴`main axis`方向，即属性`flexDirection`表示的方向排列，
如果当前主轴方向上累计的子视图总长度超过了布局在主轴方向上的长度时，子视图则向副轴`cross axis`方向(垂直于主轴)上移动一段距离来另起一行放置。

`flexlayout`很像流式布局，不过它的真正强大之处是可以按照百分比来设置视图大小和方便的设置视图间的等分间距。在某种程度上可以替代`gridlayout`和`tablelayout`。

## **父布局属性详解**

### flexDirection

定义了主轴的方向，类似于`LinearLayout`的`orientation`。
-  row(default)
-  row_reverse
-  column
-  column_reverse

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/flex-direction.gif)

### flexWrap
定义了布局是否单行，和副轴的方向。
-  nowrap(default)
-  warp
-  wrap_reverse

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/flex-wrap.gif)

### justifyContent
子视图在主轴方向上的对齐方式
-  flex_start (default) 主轴同方向对齐
-  flex_end             主轴逆方向对齐
-  center               居中
-  space_between        分散对齐，边缘子布局贴边，子布局间距相等
-  space_around         分散对齐，边缘子布局不贴边，子布局间距和与布局的间距相等

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/justify-content.gif)

### alignItems
子视图在副轴方向上的对齐方式，类似于`LinearLayout`中的`gravity`
-  stretch (default)
-  flex_start
-  flex_end
-  center
-  baseline

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/align-items.gif)


### alignContent
管理布局中多行之间的对齐方式

-  stretch (default)
-  flex_start
-  flex_end
-  center
-  space_between
-  space_around

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/align-content.gif)


## **内部子控件属性详解**

### layout_order
用其手动指定子控件摆放的顺序,默认值为1

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/layout_order.gif)

### layout_flexGrow (float)
如果子控件在主轴方向上的总长度小于父布局的长度时,决定剩余空间的占有比例. 通常使用于多行布局(`warp`,`wrap_reverse`)中.

注意:不会触发父布局的重绘.假设主轴方向为`row`,且子控件高度由宽度决定的话,有可能会出现副轴方向上控件的相互重叠情况 

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/layout_flexGrow.gif)

### layout_flexShrink (float)
如果子控件在主轴方向上排满时,决定各控件的占有比例. 通常使用于单行布局(`nowarp`)


![示例动画](https://github.com/google/flexbox-layout/blob/master/assets/layout_flexShrink.gif)


### layout_alignSelf 
主轴上一行由这一行中在副轴方向上最高的子控件决定,那么其他高度不足的控件在副轴方向上的排列方式就由属性`layout_alignSelf`决定

-  auto (default)
-  flex_start
-  flex_end
-  center
-  baseline
-  stretch (拉伸)

![示例动画](https://github.com/google/flexbox-layout/blob/master/assets/layout_alignSelf.gif)

### layout_flexBasisPercent (fraction)
指定控件在主轴方向上的长度较父布局的比例. 这一设置只有在父布局在这一方向上的测量参数(MeasureSpec)为`MeasureSpec.EXACTLY`才能生效.

注意:在flexlayout的父布局是类似ScrollView的时候,纵向上使用这个属性是没有效果的.

![示例动画](https://github.com/google/flexbox-layout/blob/master/assets/layout_flexBasisPercent.gif)

### layout_minWidth / layout_minHeight (dimension)
控件的最小宽度/高度,`layout_flexShrink`生效时,不会使控件大小小于设定的值


![示例动画](https://github.com/google/flexbox-layout/blob/master/assets/layout_minWidth.gif)

### layout_maxWidth / layout_maxWidth (dimension)
控件的最大宽度/高度,`layout_flexGrow`生效时,不会使控件大小大于设定的值


![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/layout_maxWidth.gif)

### layout_wrapBefore(boolean)

是否让当前控件另起一行

![示例动画](https://github.com/google/flexbox-layout/raw/master/assets/layout_wrapBefore.gif)
