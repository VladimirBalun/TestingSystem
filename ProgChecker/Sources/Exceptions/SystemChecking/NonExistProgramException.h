#ifndef _NON_EXIST_PROGRAM_EXCEPTION_H_
#define _NON_EXIST_PROGRAM_EXCEPTION_H_

#include "SystemCheckingException.h"

namespace Exceptions
{

    class NonExistProgramException : public SystemCheckingException
    {
    public:
        NonExistProgramException(const std::string& message) : SystemCheckingException(message) {}
        inline std::string what() override { return _message; }
    };

}

#endif
