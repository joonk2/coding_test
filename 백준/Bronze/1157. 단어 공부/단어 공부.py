# mississipi --> cnt= [1,4,4,1]

word = input().upper()
word_list = list(set(word))
cnt = [word.count(i) for i in word_list]

if cnt.count(max(cnt)) > 1:
  print("?")
else:
  print(word_list[cnt.index(max(cnt))])