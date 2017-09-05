#ifndef OO_H
#define OO_H

void* new(const void* type);
void delete(void* item);


extern const void* Object;
int differ(const void* a, const void* b);

#endif
