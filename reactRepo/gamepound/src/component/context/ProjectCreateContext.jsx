import { createContext, useContext, useEffect, useState } from "react";

const ProjectCreateMemory = createContext();

const ProjectCreateMemoryProvider = ({ children }) => {

    const [projectCreateData, setProjectCreateData] = useState();

    const [IsProjectInputChange, setIsProjectInputChange] = useState(false);
    const [projectNo, setProjectNo] = useState({});

    useEffect(() => {
        if(projectCreateData){
            setProjectNo({
                'no': projectCreateData.mainVo.no,
            });
            
        }
    }, [projectCreateData]);

    useEffect(() => {
        if(projectNo && projectNo.no){
            // 데이터 불러오기
            fetch('http://localhost:8889/gamepound/project/create/main?no=' + projectNo.no, {
                method: 'get',
            })
            .then(resp => resp.json())
            .then(data => {
                setProjectCreateData(data);
            })
            ;
        }
    }, [projectNo.no]);
    
    return (
        <ProjectCreateMemory.Provider value={{ projectCreateData, setProjectCreateData, IsProjectInputChange, setIsProjectInputChange }}>
            {children}
        </ProjectCreateMemory.Provider>
    );
};

const useProjectCreateMemory = () => {
    const context = useContext(ProjectCreateMemory);
    if (!context) {
        throw new Error("ProjectCreateMemory 컴포넌트가 아닙니다.");
    }
    return context;
};

export { ProjectCreateMemoryProvider, useProjectCreateMemory };