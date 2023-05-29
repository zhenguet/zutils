
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNZutilsSpec.h"

@interface Zutils : NSObject <NativeZutilsSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Zutils : NSObject <RCTBridgeModule>
#endif

@end
