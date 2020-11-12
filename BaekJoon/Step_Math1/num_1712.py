i_hold, i_price, i_sale = map(int, input().split());
i_breakPoint = 0;
if(i_price >= i_sale) :
  print(-1);
else :
  i_breakPoint = i_hold // (i_sale - i_price) + 1;
  print(i_breakPoint);