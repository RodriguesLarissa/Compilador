s = None
d = None
f = None
i = None
s2 = None

f = 4.0 + 4.0
print("Quanto deveria ser a nota desse compilador? 0,00 a 10,00")
i = 1
d = int(input())
while d != 10:
   BPLCV1 = False
   FLCV1 = False
   if d==1 or BPLCV1:
      print("1 é muito pouco")
      print("Acho que deveria ser mais")
      BPLCV1 = True
      FLCV1 = True
   if d==2 or BPLCV1:
      print("2 é muito pouco")
      BPLCV1 = False
      FLCV1 = True
   if d==3 or BPLCV1:
      print("3 é muito pouco")
      BPLCV1 = True
      FLCV1 = True
   if d==4 or BPLCV1:
      print("4 é muito pouco")
      BPLCV1 = False
      FLCV1 = True
   if d==5 or BPLCV1:
      print("5 é muito pouco")
      BPLCV1 = False
      FLCV1 = True
   if d==6 or BPLCV1:
      print("6 é muito pouco")
      BPLCV1 = True
      FLCV1 = True
   if d==7 or BPLCV1:
      print("7 é muito pouco")
      BPLCV1 = True
      FLCV1 = True
   if (not FLCV1) or BPLCV1:
      if d < 10:
         print("Acho que deveria ser mais")
      else:
         print("Infelizmente o limite é 10 :(")


   d = int(input())
   i = i + 1

s = "Voce precisou de"
print(s)
print(i)
if i == 1:
   print("Tentativa")
else:
   print("Tentativas")

