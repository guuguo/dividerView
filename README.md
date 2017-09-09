工具类库
=======
[![](https://jitpack.io/v/guuguo/dividerview.svg)](https://jitpack.io/#guuguo/androidLib)

不必要额外新增view来添加分隔线
# 使用
```groovy
compile "com.github.guuguo.dividerview:$version" // version 是 jitpack 徽章的 version
```
# 预览图片
<img src="http://opqb3chot.bkt.clouddn.com/dividerview_shot2.png" width = "280" height = "510" alt="图片名称" align=center />
<img src="http://opqb3chot.bkt.clouddn.com/dividerview_shot1.png" width = "280" height = "510" alt="图片名称" align=center />

# 参考的库

https://github.com/nekocode/DividerDrawable

# 使用方式

> xml 布局( xml 一个 view 只能添加一条分隔线，java代码可以添加多条)

```xml
       <top.guuguo.dividerview.DividerTextView
                android:id="@+id/text_4_4"
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:layout_weight="1"
                android:gravity="center"
                android:text="Text3"
                android:textColor="@android:color/white"
                android:textSize="16sp"
                android:textStyle="bold"
                app:dv_align="dv_TC"
                app:dv_dividerColor="@color/white"
                app:dv_dividerLength="0dp"
                app:dv_dividerWidth="3dp"
                app:dv_margin="16dp" />
```
> 代码添加 divider 方法1：
```java
tv4_2.delegate.addDivider(DividerDrawable.dv_RC, dpToPx(3), 0, Color.WHITE, dpToPx(3));
```
> 代码添加 divider 方法2：
```java
DividerDrawable.DividerLine line = new DividerDrawable.DividerLine();
line.setDividerColor(Color.WHITE)
        .setAlignType(DividerDrawable.dv_RB)
        .setDividerWidth(dpToPx(3))
        .setDividerLength(dpToPx(60))
        .setMargin(dpToPx(16));
llB.delegate.addDivider(line);
```
# 自定义参数 attr
===

```xml 
<attr name="dv_dividerWidth"/> 
<attr name="dv_dividerLength"/> //分隔线长度，为0则自适应，默认为0
<attr name="dv_dividerColor"/>  //分隔线颜色
<attr name="dv_marginStart"/>
<attr name="dv_marginEnd"/>
<attr name="dv_margin"/>
<attr name="dv_align"/>
<attr name="dv_backgroundColor"/>  //backGround失效，背景颜色用这个设置
<attr name="dv_backgroundColorPress"/> //按压时候的背景颜色
<attr name="android:textColor"/> 
<attr name="dv_textColorPress"/> //按压时候的文字颜色
<attr name="dv_dividerColorFocus"/> //按压时候的分隔线颜色
<attr name="dv_isRipple"/>
```
> 重要枚举参数,分隔线的位置
```
<attr name="dv_align">
    <enum name="dv_NO" value="0"/> //没有线，默认
    <enum name="dv_TL" value="1"/> //上左 TopLeft
    <enum name="dv_TC" value="2"/> //上中 TopCenter
    <enum name="dv_TR" value="3"/> //...
    <enum name="dv_BL" value="4"/>
    <enum name="dv_BC" value="5"/>
    <enum name="dv_BR" value="6"/>
    <enum name="dv_LT" value="7"/>
    <enum name="dv_LC" value="8"/>
    <enum name="dv_LB" value="9"/>
    <enum name="dv_RT" value="10"/>
    <enum name="dv_RC" value="11"/>
    <enum name="dv_RB" value="12"/>
</attr>
```

