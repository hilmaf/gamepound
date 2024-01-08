import { createContext, useContext, useState } from "react";

const UserMemory = createContext();

const UserMemoryProvider = ({ children }) => {
    const [loginMemberVo, setLoginMemberVo] = useState();

    return (
        <UserMemory.Provider value={{ loginMemberVo, setLoginMemberVo }}>
            {children}
        </UserMemory.Provider>
    );
};

const useUserMemory = () => {
    const context = useContext(UserMemory);
    if (!context) {
        throw new Error("UserMemoryProvider 컴포넌트가 아닙니다.");
    }
    return context;
};

export { UserMemoryProvider, useUserMemory };