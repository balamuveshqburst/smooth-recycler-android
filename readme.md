# Experimental repo to test properties of Scrollable views:

## Properties being tested:
1. Scroll functionality of nested scrollable views
2. Removal of jitter while scrolling in nested views.
3. Determining horizontal or vertical scrolling of a parent RecyclerView.

## Problem Statement:
Nested scrollables views(such as ListView, ScrollView, ViewPager and RecyclerViews) have been prone to show a noticeable jitter during user interaction.

## Probable Cause:
- Child view might be scrolling along with parent if the user starts scroll action from the child.


## Viable Solutions:

### 1. Enclose child Scrollable View in a CardView (Check branch card_view for implementation. [Link to XML file](https://github.com/balamuveshqburst/smooth-recycler-android/blob/cardview/app/src/main/res/layout/child_recycler.xml)):
  - Use this solution if it fits your UI requirements.
  - This seems to work because when you have multiple scrolling views in your layout (eg. RecyclerView + ScrollView) and when you scroll while in your recyclerView, the recyclerView scrolls with the parent Scrollview. this causes jitters in RecyclerView.

### 2. Create a subclass of RecyclerView and override function `onInterceptTouchEvent(e: MotionEvent)` (Check branch custom_RV for implementation. [Link to file](https://github.com/balamuveshqburst/smooth-recycler-android/blob/custom_RV/app/src/main/java/com/balamuvesh/smoothrecyclerview/utils/ParentRecyclerView.kt))
  - Use this if your parent scrollable view is a RecyclerView.
  - In the subclass override method `onInterceptTouchEvent(..)`
      - From within it `return super.onInterceptTouchEvent(..) && mGestureDetector.onTouchEvent(e)`
      - mGestureDetector is a object of the below described subclass
  - Also create a subclass of `GestureDetector.SimpleGetsureListener()`. In it override function `onScroll(..)` to return true if raw vertical motion is greater than raw horizontal delta.
  
### 3. Set layout attribute `android:nestedScrollingEnabled="false"`
- Only applicable if child scrollable is a RecyclerView
- Programmatically: `recyclerView.setNestedScrollingEnabled(false);`
  
### 4. The hacky method- Implement a custom LinearLayout Manager (Check branch custom_layout_manager for implementation. [Link to file](https://github.com/balamuveshqburst/smooth-recycler-android/blob/custom_layout_manager/app/src/main/java/com/balamuvesh/smoothrecyclerview/utils/CustomLinearLayoutManager.kt)):
   - This technique disables Horizontal and Vertical scrolling for the RecyclerView depending on specified orientation.
   - __NOT RECOMMENDED__, as it might be prone to errors
  
 
