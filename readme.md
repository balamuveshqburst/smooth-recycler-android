#Experimental repo to test properties of RecyclerViews:

## **Properties being tested:**
1. Scroll functionality of nested RVs
2. Removal of jitter while scrolling in nested views.
3. Determining horizontal or vertical scrolling in Nested RVs

## **Viable Solutions:**

### 1. Enclose child RecyclerView in a CardView (Check branch card_view for implementation):
  - This seems to work because when you have multiple scrolling views in your layout (eg. RecyclerView + ScrollView) and when you scroll while in your recyclerView, the recyclerView scrolls with the parent Scrollview. this causes jitters in RecyclerView.

### 2. Create a subclass of RecyclerView and override function onInterceptTouchEvent (Check branch custom_RV for implementation)

  - In the subclass override method 'onInterceptTouchEvent(..)'
      - From within it return super.onInterceptTouchEvent(..) && mGestureDetector.onTouchEvent(e)
      - mGestureDetector is a object of the below described subclass
      
  - Also create a subclass of GestureDetector.SimpleGetsureListener(). In it override function onScroll(..) to return true if raw vertical motion is greater than raw horizontal delta
  
### 3. The hacky method- Implement a custom LinearLayout Manager (Check branch custom_layout_manager for implementation):
   - This technique disables Horizontal and Vertical scrolling for the RecyclerView depending on specified orientation.
   - __NOT RECOMMENDED__, as it might be prone to errors
  
 
