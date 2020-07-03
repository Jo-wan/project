#鸡兔同笼，上有35头，下有94足，问鸡兔各几只？
heads = 35
feet = 94
rabbits_feet = feet - heads * 2
rabbits = rabbits_feet / 2
chicken = heads - rabbits
print(feet == chicken * 2 +rabbits * 4 )
print("Number of chicken = %d," % chicken,"Number of rabbits = %d" % rabbits)
