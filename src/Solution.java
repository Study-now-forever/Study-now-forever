import java.util.LinkedList;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
    	//数据处理，转化成链表
      LinkedList<Integer> listPush=new LinkedList<Integer>();
      LinkedList<Integer> listPop=new LinkedList<Integer>();
      for(int i=0;i<pushA.length;i++) {
    	  listPush.add(pushA[i]);
      }
      for(Integer each:popA)
      {
    	  listPop.add(each);
      }
      //按照规律循环减小
      while(!listPush.isEmpty()) {
    	  int x=listPop.remove();//第一个弹出的数据
    	  int index=listPush.indexOf(x);//取出其压入索引
    	  if(index<0)return false;
    	  int j=0;
    	  for(int i=index-1;i>=0;--i) {//将其之前的数据检查顺序，合格则移出pop序列，否则直接报错
    		  int obj=listPush.get(i);
    		  
    		  for(;j<listPop.size();++j) {
    			  if(listPop.get(j).equals(obj))break;
    		  }
    		  if(j>=listPop.size())return false;//没有找到
    		  listPop.remove(j);
    	  }
    	  for(int i=index;i>=0;i--) {//将push序列也进行缩小处理
    		  listPush.remove();
    	  }
      }
      
      
      
    	return true;
    }
    public static void main(String[]args) {
    	int[]pushA= {1,2,3,4,5};
    	int[]popA= {4,5,3,2,1};
    	Solution s=new 
    			Solution();
    	System.out.println(s.IsPopOrder(pushA, popA));
    }
}